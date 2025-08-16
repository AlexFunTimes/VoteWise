// billing/BillingManager.kt (package com.votewise.app.billing)
import android.content.Context
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class BillingManager(private val context: Context) {
    private val purchasesUpdatedListener = PurchasesUpdatedListener { billingResult: BillingResult, purchases: List<com.android.billingclient.api.Purchase>? ->
        // Handle purchase updates (e.g., grant premium access)
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            // Process purchases
        }
    }

    private val billingClient = BillingClient.newBuilder(context)
        .setListener(purchasesUpdatedListener)
        .enablePendingPurchases(
            PendingPurchasesParams.newBuilder()
                .enableOneTimeProducts()
                .build()
        )
        .build()

    init {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    queryProducts()
                }
            }

            override fun onBillingServiceDisconnected() {
                // Retry connection logic here
            }
        })
    }

    private fun queryProducts() {
        val productList = listOf(
            QueryProductDetailsParams.Product.newBuilder()
                .setProductId("premium_subscription_monthly")
                .setProductType(BillingClient.ProductType.SUBS)
                .build(),
            QueryProductDetailsParams.Product.newBuilder()
                .setProductId("report_bundle_10")
                .setProductType(BillingClient.ProductType.INAPP)
                .build()
        )
        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(productList)
            .build()
        billingClient.queryProductDetailsAsync(params) { billingResult, productDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                // Use productDetailsList to launch flows (e.g., billingClient.launchBillingFlow)
            }
        }
    }

    // Launch purchase flow (call from UI, e.g., on premium button click)
    fun launchPurchaseFlow(activity: androidx.activity.ComponentActivity, productDetails: com.android.billingclient.api.ProductDetails) {
        val flowParams = com.android.billingclient.api.BillingFlowParams.newBuilder()
            .setProductDetailsParamsList(
                listOf(
                    com.android.billingclient.api.BillingFlowParams.ProductDetailsParams.newBuilder()
                        .setProductDetails(productDetails)
                        .build()
                )
            )
            .build()
        billingClient.launchBillingFlow(activity, flowParams)
    }

    // AdMob integration for free tier
    fun loadBanner(adView: AdView) {
        adView.loadAd(AdRequest.Builder().build())
    }

    // Check premium status (e.g., in ViewModel)
    fun isPremium(): Boolean {
        // Query purchases with billingClient.queryPurchasesAsync(BillingClient.ProductType.SUBS)
        // Return true if active subscription found
        return false  // Placeholder
    }
}
package com.ujjwal.sneakers.utilities

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import timber.log.Timber


fun Fragment.navigate(navDirections: NavDirections) {
    try {
        findNavController().navigate(navDirections)
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}

fun Fragment.navigate(uri: Uri) {
    try {
        findNavController().navigate(uri)
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}

fun Fragment.navigateBack() {
    try {
        findNavController().navigateUp()
    } catch (exc: Exception) {
        Timber.e(exc.message)
    }
}

//fun Fragment.shareProduct(postName: String) {
//    try {
//        //firebase analytics event logs for share the article
//        setAnalyticsLogsEvents("ArticleShare", "ArticleShare", CONSTANTS.FIREBASE_SHARE)
//        val shareIntent = Intent()
//        shareIntent.action = Intent.ACTION_SEND
//        shareIntent.type = "text/plain"
//        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.geeksforgeeks.org/$postName/")
//        startActivity(Intent.createChooser(shareIntent, getString(R.string.share)))
//    } catch (ignore: Exception) {
//    }
//}

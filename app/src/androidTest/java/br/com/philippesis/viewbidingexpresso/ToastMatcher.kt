package br.com.philippesis.viewbidingexpresso

import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher : TypeSafeMatcher<Root>() {

    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }

    override fun matchesSafely(item: Root): Boolean {
        val viewTitle = (item.decorView.layoutParams as WindowManager.LayoutParams).title
            if (viewTitle == WINDOW_TOAST) {
                val windowToken = item.decorView.windowToken
                val appToken = item.decorView.applicationWindowToken
                return windowToken == appToken
            }

        return false
    }

    companion object {
        const val WINDOW_TOAST = "Toast"
    }
}
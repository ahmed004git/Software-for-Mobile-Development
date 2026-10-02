package com.example.assignment01

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat

enum class NavTab {
    HOME, FRIENDS, MARKETPLACE, NOTIFICATIONS, MENU
}

object TopNavHelper {
    fun setupTopNav(activity: Activity, activeTab: NavTab) {
        val tabHome = activity.findViewById<View>(R.id.tab_home) ?: return
        val tabFriends = activity.findViewById<View>(R.id.tab_friends) ?: return
        val tabMarketplace = activity.findViewById<View>(R.id.tab_marketplace) ?: return
        val tabNotifications = activity.findViewById<View>(R.id.tab_notifications) ?: return
        val tabMenu = activity.findViewById<View>(R.id.tab_menu) ?: return

        val ivHome = activity.findViewById<ImageView>(R.id.iv_tab_home)
        val ivFriends = activity.findViewById<ImageView>(R.id.iv_tab_friends)
        val ivMarketplace = activity.findViewById<ImageView>(R.id.iv_tab_marketplace)
        val ivNotifications = activity.findViewById<ImageView>(R.id.iv_tab_notifications)
        val ivMenu = activity.findViewById<ImageView>(R.id.iv_tab_menu)

        val indHome = activity.findViewById<View>(R.id.indicator_home)
        val indFriends = activity.findViewById<View>(R.id.indicator_friends)
        val indMarketplace = activity.findViewById<View>(R.id.indicator_marketplace)
        val indNotifications = activity.findViewById<View>(R.id.indicator_notifications)
        val indMenu = activity.findViewById<View>(R.id.indicator_menu)

        val tealColor = ContextCompat.getColor(activity, R.color.primary_teal)
        val greyColor = ContextCompat.getColor(activity, R.color.icon_grey)

        ivHome?.setColorFilter(if (activeTab == NavTab.HOME) tealColor else greyColor)
        indHome?.visibility = if (activeTab == NavTab.HOME) View.VISIBLE else View.GONE

        ivFriends?.setColorFilter(if (activeTab == NavTab.FRIENDS) tealColor else greyColor)
        indFriends?.visibility = if (activeTab == NavTab.FRIENDS) View.VISIBLE else View.GONE

        ivMarketplace?.setColorFilter(if (activeTab == NavTab.MARKETPLACE) tealColor else greyColor)
        indMarketplace?.visibility = if (activeTab == NavTab.MARKETPLACE) View.VISIBLE else View.GONE

        ivNotifications?.setColorFilter(if (activeTab == NavTab.NOTIFICATIONS) tealColor else greyColor)
        indNotifications?.visibility = if (activeTab == NavTab.NOTIFICATIONS) View.VISIBLE else View.GONE

        ivMenu?.setColorFilter(if (activeTab == NavTab.MENU) tealColor else greyColor)
        indMenu?.visibility = if (activeTab == NavTab.MENU) View.VISIBLE else View.GONE

        tabHome.setOnClickListener {
            if (activeTab != NavTab.HOME) {
                activity.startActivity(Intent(activity, HomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                })
            }
        }
        tabFriends.setOnClickListener {
            if (activeTab != NavTab.FRIENDS) {
                activity.startActivity(Intent(activity, FriendsActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                })
            }
        }
        tabMarketplace.setOnClickListener {
            if (activeTab != NavTab.MARKETPLACE) {
                activity.startActivity(Intent(activity, MarketplaceActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                })
            }
        }
        tabNotifications.setOnClickListener {
            if (activeTab != NavTab.NOTIFICATIONS) {
                activity.startActivity(Intent(activity, NotificationsActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                })
            }
        }
        tabMenu.setOnClickListener {
            if (activeTab != NavTab.MENU) {
                activity.startActivity(Intent(activity, MenuActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                })
            }
        }
    }
}
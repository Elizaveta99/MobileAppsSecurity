package com.android.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numberOfInstalledApps = 0
    var numberOfNonSystemApps = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberOfInstalledApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA).size // ??

        val appList = packageManager.getInstalledApplications(0)
        for (info in appList) {
            if (info.flags and ApplicationInfo.FLAG_SYSTEM == 0) {
                numberOfNonSystemApps++
            }
        }
    }

    fun button1(view: View) {
        textViewAns1.text = numberOfInstalledApps.toString()
    }

    fun button2(view: View) {
        textViewAns2.text = numberOfNonSystemApps.toString()
    }
}

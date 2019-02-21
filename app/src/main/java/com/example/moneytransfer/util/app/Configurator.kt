package com.example.moneytransfer.util.app

import android.app.Activity
import android.os.Handler
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import java.util.ArrayList

//import org.omg.PortableInterceptor.Interceptor
//import sun.security.krb5.internal.KDCOptions.with


//import org.omg.PortableInterceptor.Interceptor


/**
 * Created by sai on 13/3/2018.
 */
open class Configurator {

    companion object {
        private val KST_CONFIGS = mutableMapOf<Any, Any>()
        private val HANDLER = Handler()
        private val INTERCEPTORS = ArrayList<Interceptor>()
        private val INSTANCE = Configurator()

        fun getInstance(): Configurator {
            return Companion.Holder.INSTANCE
        }

        private object Holder {
            val INSTANCE = Configurator()
        }

    }

    private constructor() {
        KST_CONFIGS[ConfigKeys.CONFIG_READY] = false
        KST_CONFIGS[ConfigKeys.HANDLER] = HANDLER
    }

    fun getKstConfigs(): MutableMap<Any, Any> {
        return KST_CONFIGS
    }

    fun configure() {
//        initIcons()
        Logger.addLogAdapter(AndroidLogAdapter())
        KST_CONFIGS[ConfigKeys.CONFIG_READY] = true
//        Utils.init(AppController.getApplication())
    }

    fun withApiHost(host: String): Configurator {
        KST_CONFIGS[ConfigKeys.API_HOST] = host
        return this
    }

    fun withLoaderDelayed(host: Long): Configurator {
        KST_CONFIGS[ConfigKeys.LOADER_DELAYED] = host
        return this
    }

//    private fun initIcons() {
//        if (ICONS.size() > 0) {
//            val initializer = Iconify.with(ICONS.get(0))
//            for (i in 1 until ICONS.size()) {
//                initializer.with(ICONS.get(i))
//            }
//        }
//    }

//    fun withIcon(font: ITypeface): Configurator {
//        Iconics.registerFont(font)
//        return this
//    }

    fun withInterceptor(interceptor: Interceptor): Configurator {
        INTERCEPTORS.add(interceptor)
        KST_CONFIGS[ConfigKeys.INTERCEPTOR] = INTERCEPTORS
        return this
    }

    fun withInterceptors(interceptors: ArrayList<Interceptor>): Configurator {
        INTERCEPTORS.addAll(interceptors)
        KST_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS)
        return this
    }

    fun withActivity(activity: Activity): Configurator {
        KST_CONFIGS[ConfigKeys.ACTIVITY] = activity
        return this
    }

    private fun checkConfiguration() {
        val isReady: Boolean = KST_CONFIGS[ConfigKeys.CONFIG_READY] as Boolean
    }


    fun <T> getConfiguration(key: Any): T {
        this.checkConfiguration()
        val value = KST_CONFIGS[key]
                ?: throw NullPointerException(key.toString() + " IS NULL")
        return KST_CONFIGS[key] as T
    }


}
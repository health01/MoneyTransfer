package com.example.moneytransfer.util.app

import android.content.Context
import android.os.Handler

/**
 * Created by sai on 13/3/2018.
 */
object AppController {

        //initial the Context
        fun init(context: Context): Configurator {
            Configurator
                    .getInstance()
                    .getKstConfigs()
                    .put(ConfigKeys.APPLICATION_CONTEXT, context.applicationContext)
            return Configurator.getInstance()
        }

        //get config instance
        private fun getConfigurator(): Configurator {
            return Configurator.getInstance()
        }

        fun <T> getConfiguration(key: Any): T {
            return getConfigurator().getConfiguration(key)
        }

        //get app context
        fun getApplication(): Context {
            return getConfiguration(ConfigKeys.APPLICATION_CONTEXT)
        }


        //get app handler
        fun getHandler(): Handler {
            return getConfiguration(ConfigKeys.HANDLER)
        }

}
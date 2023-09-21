// 
// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Autogenerated from Pigeon (v11.0.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.amazonaws.amplify.amplify_auth_cognito

import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any?> {
  if (exception is FlutterError) {
    return listOf(
      exception.code,
      exception.message,
      exception.details
    )
  } else {
    return listOf(
      exception.javaClass.simpleName,
      exception.toString(),
      "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
    )
  }
}

/**
 * Error class for passing custom error details to Flutter via a thrown PlatformException.
 * @property code The error code.
 * @property message The error message.
 * @property details The error details. Must be a datatype supported by the api codec.
 */
class FlutterError (
  val code: String,
  override val message: String? = null,
  val details: Any? = null
) : Throwable()

/** Generated class from Pigeon that represents data sent in messages. */
data class NativeUserContextData (
  val deviceName: String? = null,
  val thirdPartyDeviceId: String? = null,
  val deviceFingerprint: String? = null,
  val applicationName: String? = null,
  val applicationVersion: String? = null,
  val deviceLanguage: String? = null,
  val deviceOsReleaseVersion: String? = null,
  val screenHeightPixels: Long? = null,
  val screenWidthPixels: Long? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): NativeUserContextData {
      val deviceName = list[0] as String?
      val thirdPartyDeviceId = list[1] as String?
      val deviceFingerprint = list[2] as String?
      val applicationName = list[3] as String?
      val applicationVersion = list[4] as String?
      val deviceLanguage = list[5] as String?
      val deviceOsReleaseVersion = list[6] as String?
      val screenHeightPixels = list[7].let { if (it is Int) it.toLong() else it as Long? }
      val screenWidthPixels = list[8].let { if (it is Int) it.toLong() else it as Long? }
      return NativeUserContextData(deviceName, thirdPartyDeviceId, deviceFingerprint, applicationName, applicationVersion, deviceLanguage, deviceOsReleaseVersion, screenHeightPixels, screenWidthPixels)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      deviceName,
      thirdPartyDeviceId,
      deviceFingerprint,
      applicationName,
      applicationVersion,
      deviceLanguage,
      deviceOsReleaseVersion,
      screenHeightPixels,
      screenWidthPixels,
    )
  }
}

/** Generated class from Pigeon that represents data sent in messages. */
data class LegacyCredentialStoreData (
  val identityId: String? = null,
  val accessKeyId: String? = null,
  val secretAccessKey: String? = null,
  val sessionToken: String? = null,
  val expirationMsSinceEpoch: Long? = null,
  val accessToken: String? = null,
  val refreshToken: String? = null,
  val idToken: String? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): LegacyCredentialStoreData {
      val identityId = list[0] as String?
      val accessKeyId = list[1] as String?
      val secretAccessKey = list[2] as String?
      val sessionToken = list[3] as String?
      val expirationMsSinceEpoch = list[4].let { if (it is Int) it.toLong() else it as Long? }
      val accessToken = list[5] as String?
      val refreshToken = list[6] as String?
      val idToken = list[7] as String?
      return LegacyCredentialStoreData(identityId, accessKeyId, secretAccessKey, sessionToken, expirationMsSinceEpoch, accessToken, refreshToken, idToken)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      identityId,
      accessKeyId,
      secretAccessKey,
      sessionToken,
      expirationMsSinceEpoch,
      accessToken,
      refreshToken,
      idToken,
    )
  }
}

/** Generated class from Pigeon that represents Flutter messages that can be called from Kotlin. */
@Suppress("UNCHECKED_CAST")
class NativeAuthPlugin(private val binaryMessenger: BinaryMessenger) {
  companion object {
    /** The codec used by NativeAuthPlugin. */
    val codec: MessageCodec<Any?> by lazy {
      StandardMessageCodec()
    }
  }
  /**
   * Exchanges the route parameters used to launch the app, i.e. if the app
   * was closed and a redirect happened to the custom URI scheme (iOS) or an
   * intent was launched with the redirect parameters (Android).
   */
  fun exchange(paramsArg: Map<String, String>, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthPlugin.exchange", codec)
    channel.send(listOf(paramsArg)) {
      callback()
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object NativeAuthBridgeCodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          LegacyCredentialStoreData.fromList(it)
        }
      }
      129.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          NativeUserContextData.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is LegacyCredentialStoreData -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      is NativeUserContextData -> {
        stream.write(129)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface NativeAuthBridge {
  /**
   * Sign in by presenting [url] and waiting for a response to a URL with
   * [callbackUrlScheme].
   *
   * If [preferPrivateSession] is `true`, do not persist session cookies.
   */
  fun signInWithUrl(url: String, callbackUrlScheme: String, preferPrivateSession: Boolean, browserPackageName: String?, callback: (Result<Map<String, String>>) -> Unit)
  /**
   * Sign out by presenting [url] and waiting for a response to a URL with
   * [callbackUrlScheme].
   */
  fun signOutWithUrl(url: String, callbackUrlScheme: String, preferPrivateSession: Boolean, browserPackageName: String?, callback: (Result<Unit>) -> Unit)
  /** Retrieves the validation data for the current iOS/Android device. */
  fun getValidationData(): Map<String, String>
  /** Retrieves context data as required for advanced security features (ASF). */
  fun getContextData(): NativeUserContextData
  fun getBundleId(): String
  /** Fetch legacy credentials stored by native SDKs. */
  fun getLegacyCredentials(identityPoolId: String?, appClientId: String?, callback: (Result<LegacyCredentialStoreData>) -> Unit)
  /** Clears the legacy credential store data. */
  fun clearLegacyCredentials(callback: (Result<Unit>) -> Unit)

  companion object {
    /** The codec used by NativeAuthBridge. */
    val codec: MessageCodec<Any?> by lazy {
      NativeAuthBridgeCodec
    }
    /** Sets up an instance of `NativeAuthBridge` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: NativeAuthBridge?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.signInWithUrl", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val urlArg = args[0] as String
            val callbackUrlSchemeArg = args[1] as String
            val preferPrivateSessionArg = args[2] as Boolean
            val browserPackageNameArg = args[3] as String?
            api.signInWithUrl(urlArg, callbackUrlSchemeArg, preferPrivateSessionArg, browserPackageNameArg) { result: Result<Map<String, String>> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.signOutWithUrl", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val urlArg = args[0] as String
            val callbackUrlSchemeArg = args[1] as String
            val preferPrivateSessionArg = args[2] as Boolean
            val browserPackageNameArg = args[3] as String?
            api.signOutWithUrl(urlArg, callbackUrlSchemeArg, preferPrivateSessionArg, browserPackageNameArg) { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.getValidationData", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getValidationData())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.getContextData", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getContextData())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.getBundleId", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped: List<Any?>
            try {
              wrapped = listOf<Any?>(api.getBundleId())
            } catch (exception: Throwable) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.getLegacyCredentials", codec)
        if (api != null) {
          channel.setMessageHandler { message, reply ->
            val args = message as List<Any?>
            val identityPoolIdArg = args[0] as String?
            val appClientIdArg = args[1] as String?
            api.getLegacyCredentials(identityPoolIdArg, appClientIdArg) { result: Result<LegacyCredentialStoreData> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                val data = result.getOrNull()
                reply.reply(wrapResult(data))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.amplify_auth_cognito.NativeAuthBridge.clearLegacyCredentials", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            api.clearLegacyCredentials() { result: Result<Unit> ->
              val error = result.exceptionOrNull()
              if (error != null) {
                reply.reply(wrapError(error))
              } else {
                reply.reply(wrapResult(null))
              }
            }
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}

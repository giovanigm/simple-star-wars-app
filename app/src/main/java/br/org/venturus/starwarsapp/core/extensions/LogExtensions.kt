package br.org.venturus.starwarsapp.core.extensions

import timber.log.Timber

/**
 * Logs with [Timber] in a debug way.
 */
inline fun logD(lambda: () -> String) = Timber.d(lambda())

/**
 * Logs with [Timber] in a error way.
 */
inline fun logE(lambda: () -> String) = Timber.e(lambda())
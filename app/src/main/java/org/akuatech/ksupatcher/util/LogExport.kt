package org.akuatech.ksupatcher.util

import android.content.Context
import android.net.Uri
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val LOG_FILE_TIMESTAMP: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")

fun defaultLogFileName(scope: String): String {
    val timestamp = LocalDateTime.now().format(LOG_FILE_TIMESTAMP)
    return "ksupatcher-$scope-log-$timestamp.txt"
}

fun writeLogToUri(context: Context, uri: Uri, log: String): Result<Unit> = runCatching {
    val output = requireNotNull(context.contentResolver.openOutputStream(uri)) {
        "Unable to open selected file"
    }
    output.bufferedWriter().use { writer ->
        writer.write(log)
    }
}

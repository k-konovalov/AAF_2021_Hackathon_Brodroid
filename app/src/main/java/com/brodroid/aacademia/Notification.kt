package com.brodroid.aacademia

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import java.time.Instant

interface Notification {
    fun initialize()
    fun showNotification(lesson: Lesson)
}

class NewLessonNotification(private val context: Context) : Notification {
    var notificationManager: NotificationManagerCompat? = null
    init {
        notificationManager = NotificationManagerCompat.from(context)
        // Create the NotificationChannel
        val name = "New lesson arrived"
        val descriptionText = "New lesson was added to AA!"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val mChannel = NotificationChannel("AA", name, importance)
        mChannel.description = descriptionText
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        val channel = notificationManager?.createNotificationChannel(mChannel)
    }
    override fun initialize() {
        TODO("Not yet implemented")
    }

    override fun showNotification(lesson: Lesson) {
        val pIntent_showLesson = PendingIntent.getActivity(
            context, 1,
            Intent(context, MainActivity::class.java,)
                .setAction(Intent.ACTION_VIEW)
                .setData("https://com.brodroid.aacademy/lesson/${lesson.id}".toUri()),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(context, "AA")
            .setContentTitle(lesson.name)
            .setContentText(lesson.date)
            .setWhen(Instant.now().toEpochMilli())
            .setContentIntent(pIntent_showLesson)
            .setStyle(NotificationCompat.BigTextStyle())
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .build()

        notificationManager?.notify("lesson", 1, notification)
    }

}
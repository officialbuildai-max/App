package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public class g0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final URL f32138a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Future f32139b;

    /* renamed from: c, reason: collision with root package name */
    private Task f32140c;

    private g0(URL url) {
        this.f32138a = url;
    }

    private byte[] h() {
        URLConnection openConnection = this.f32138a.openConnection();
        if (openConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = openConnection.getInputStream();
        try {
            byte[] d11 = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + d11.length + " bytes from " + this.f32138a);
            }
            if (d11.length <= 1048576) {
                return d11;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static g0 i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(d());
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32139b.cancel(true);
    }

    public Bitmap d() {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Starting download of: ");
            sb2.append(this.f32138a);
        }
        byte[] h11 = h();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(h11, 0, h11.length);
        if (decodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f32138a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Successfully downloaded image: ");
            sb3.append(this.f32138a);
        }
        return decodeByteArray;
    }

    public Task k() {
        return (Task) Preconditions.checkNotNull(this.f32140c);
    }

    public void m(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f32139b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.f0
            @Override // java.lang.Runnable
            public final void run() {
                g0.this.l(taskCompletionSource);
            }
        });
        this.f32140c = taskCompletionSource.getTask();
    }
}

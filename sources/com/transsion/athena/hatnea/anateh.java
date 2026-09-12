package com.transsion.athena.hatnea;

import android.os.Handler;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public abstract class anateh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected Handler f42815a;

    /* renamed from: b, reason: collision with root package name */
    protected Thread f42816b;

    /* JADX INFO: Access modifiers changed from: protected */
    public anateh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public anateh(@NonNull Handler handler) {
        this.f42815a = handler;
    }

    protected abstract void a();

    public String b() {
        return "Task-Athena-" + c();
    }

    protected abstract String c();

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.f42816b = currentThread;
        String name = currentThread.getName();
        this.f42816b.setName(b());
        try {
            a();
        } catch (Exception e11) {
            e11.printStackTrace();
        } finally {
            athena.a().b(this);
            this.f42816b.setName(name);
        }
    }
}

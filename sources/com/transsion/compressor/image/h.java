package com.transsion.compressor.image;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes5.dex */
public class h implements Handler.Callback {

    /* renamed from: h, reason: collision with root package name */
    private static Random f44049h;

    /* renamed from: a, reason: collision with root package name */
    private String f44050a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44051b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44052c;

    /* renamed from: d, reason: collision with root package name */
    private final e f44053d;

    /* renamed from: e, reason: collision with root package name */
    private final com.transsion.compressor.image.a f44054e;

    /* renamed from: f, reason: collision with root package name */
    private final List f44055f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f44056g;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f44057a;

        /* renamed from: b, reason: collision with root package name */
        private String f44058b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f44059c;

        /* renamed from: e, reason: collision with root package name */
        private e f44061e;

        /* renamed from: f, reason: collision with root package name */
        private com.transsion.compressor.image.a f44062f;

        /* renamed from: d, reason: collision with root package name */
        private int f44060d = 100;

        /* renamed from: g, reason: collision with root package name */
        private final List f44063g = new ArrayList();

        /* renamed from: com.transsion.compressor.image.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0616a extends c {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f44064b;

            C0616a(String str) {
                this.f44064b = str;
            }

            @Override // com.transsion.compressor.image.c
            public InputStream a() {
                return new FileInputStream(this.f44064b);
            }

            @Override // com.transsion.compressor.image.d
            public String getPath() {
                return this.f44064b;
            }
        }

        a(Context context) {
            this.f44057a = context;
        }

        static /* bridge */ /* synthetic */ f e(a aVar) {
            aVar.getClass();
            return null;
        }

        private h h() {
            return new h(this);
        }

        public void i() {
            try {
                File e11 = j.e(this.f44057a);
                if (e11 != null) {
                    this.f44058b = e11.getAbsolutePath();
                }
                j.d(new File(this.f44058b));
            } catch (Exception unused) {
            }
        }

        public a j(com.transsion.compressor.image.a aVar) {
            this.f44062f = aVar;
            return this;
        }

        public void k() {
            h().g(this.f44057a);
        }

        public a l(String str) {
            this.f44063g.add(new C0616a(str));
            return this;
        }

        public a m(e eVar) {
            this.f44061e = eVar;
            return this;
        }
    }

    static {
        SecureRandom instanceStrong;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                instanceStrong = SecureRandom.getInstanceStrong();
                f44049h = instanceStrong;
            } else {
                f44049h = new Random();
            }
        } catch (NoSuchAlgorithmException e11) {
            j.f(Log.getStackTraceString(e11));
        }
    }

    private h(a aVar) {
        this.f44050a = aVar.f44058b;
        a.e(aVar);
        this.f44055f = aVar.f44063g;
        this.f44053d = aVar.f44061e;
        this.f44052c = aVar.f44060d;
        this.f44054e = aVar.f44062f;
        this.f44051b = aVar.f44059c;
        this.f44056g = new Handler(Looper.getMainLooper(), this);
    }

    private File c(Context context, d dVar) {
        try {
            return d(context, dVar);
        } finally {
            dVar.close();
        }
    }

    private File d(Context context, d dVar) {
        Checker checker = Checker.SINGLE;
        File e11 = e(context, checker.extSuffix(dVar));
        com.transsion.compressor.image.a aVar = this.f44054e;
        return aVar != null ? (aVar.a(dVar.getPath()) && checker.needCompress(this.f44052c, dVar.getPath())) ? new b(dVar, e11, this.f44051b).a() : new File(dVar.getPath()) : checker.needCompress(this.f44052c, dVar.getPath()) ? new b(dVar, e11, this.f44051b).a() : new File(dVar.getPath());
    }

    private File e(Context context, String str) {
        File e11;
        if (TextUtils.isEmpty(this.f44050a) && (e11 = j.e(context)) != null) {
            this.f44050a = e11.getAbsolutePath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f44050a);
        sb2.append(File.separator);
        sb2.append(System.currentTimeMillis());
        sb2.append(f44049h.nextInt(1000));
        if (TextUtils.isEmpty(str)) {
            str = ".jpg";
        }
        sb2.append(str);
        File file = new File(sb2.toString());
        j.c(file);
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(d dVar, Context context) {
        try {
            Message obtainMessage = this.f44056g.obtainMessage(1);
            obtainMessage.obj = dVar.getPath();
            this.f44056g.sendMessage(obtainMessage);
            File c11 = c(context, dVar);
            int[] a11 = j.a(c11);
            Message obtainMessage2 = this.f44056g.obtainMessage(0, c11);
            Bundle bundle = new Bundle();
            bundle.putIntArray("tag_image_info", a11);
            bundle.putLong("tag_image_size", c11.length() / 1024);
            obtainMessage2.setData(bundle);
            this.f44056g.sendMessage(obtainMessage2);
        } catch (IOException e11) {
            Handler handler = this.f44056g;
            handler.sendMessage(handler.obtainMessage(2, e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final Context context) {
        e eVar;
        e eVar2;
        if (context == null && (eVar2 = this.f44053d) != null) {
            eVar2.onError(new NullPointerException("context cannot be null"));
        }
        if (this.f44055f.size() == 0 && (eVar = this.f44053d) != null) {
            eVar.onError(new NullPointerException("image file cannot be null"));
            return;
        }
        Iterator it = this.f44055f.iterator();
        while (it.hasNext()) {
            final d dVar = (d) it.next();
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: com.transsion.compressor.image.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.f(dVar, context);
                }
            });
            it.remove();
        }
    }

    public static a h(Context context) {
        return new a(context.getApplicationContext());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        e eVar = this.f44053d;
        if (eVar == null) {
            return true;
        }
        int i11 = message.what;
        if (i11 == 0) {
            File file = (File) message.obj;
            Bundle data = message.getData();
            this.f44053d.b(file, data.getIntArray("tag_image_info"), data.getLong("tag_image_size"));
            return false;
        }
        if (i11 == 1) {
            eVar.a((String) message.obj);
            return false;
        }
        if (i11 != 2) {
            return false;
        }
        eVar.onError((Throwable) message.obj);
        return false;
    }
}

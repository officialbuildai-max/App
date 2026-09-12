package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import uc.f;
import vc.k;

/* loaded from: classes.dex */
public class FirebasePerfUrlConnection {
    static Object a(j jVar, k kVar, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        i b11 = i.b(kVar);
        try {
            URLConnection a11 = jVar.a();
            return a11 instanceof HttpsURLConnection ? new b((HttpsURLConnection) a11, timer, b11).getContent() : a11 instanceof HttpURLConnection ? new a((HttpURLConnection) a11, timer, b11).getContent() : a11.getContent();
        } catch (IOException e11) {
            b11.k(micros);
            b11.o(timer.getDurationMicros());
            b11.q(jVar.toString());
            f.d(b11);
            throw e11;
        }
    }

    static Object b(j jVar, Class[] clsArr, k kVar, Timer timer) {
        timer.reset();
        long micros = timer.getMicros();
        i b11 = i.b(kVar);
        try {
            URLConnection a11 = jVar.a();
            return a11 instanceof HttpsURLConnection ? new b((HttpsURLConnection) a11, timer, b11).getContent(clsArr) : a11 instanceof HttpURLConnection ? new a((HttpURLConnection) a11, timer, b11).getContent(clsArr) : a11.getContent(clsArr);
        } catch (IOException e11) {
            b11.k(micros);
            b11.o(timer.getDurationMicros());
            b11.q(jVar.toString());
            f.d(b11);
            throw e11;
        }
    }

    static InputStream c(j jVar, k kVar, Timer timer) {
        if (!k.k().u()) {
            return jVar.a().getInputStream();
        }
        timer.reset();
        long micros = timer.getMicros();
        i b11 = i.b(kVar);
        try {
            URLConnection a11 = jVar.a();
            return a11 instanceof HttpsURLConnection ? new b((HttpsURLConnection) a11, timer, b11).getInputStream() : a11 instanceof HttpURLConnection ? new a((HttpURLConnection) a11, timer, b11).getInputStream() : a11.getInputStream();
        } catch (IOException e11) {
            b11.k(micros);
            b11.o(timer.getDurationMicros());
            b11.q(jVar.toString());
            f.d(b11);
            throw e11;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return a(new j(url), k.k(), new Timer());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return b(new j(url), clsArr, k.k(), new Timer());
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        return obj instanceof HttpsURLConnection ? new b((HttpsURLConnection) obj, new Timer(), i.b(k.k())) : obj instanceof HttpURLConnection ? new a((HttpURLConnection) obj, new Timer(), i.b(k.k())) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return c(new j(url), k.k(), new Timer());
    }
}

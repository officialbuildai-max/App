package com.transsion.ad.strategy;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f42288a = new h();

    private h() {
    }

    private final String b() {
        String simpleName = h.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final boolean a(String str, String destination) {
        InputStream byteStream;
        Intrinsics.h(destination, "destination");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Response execute = FirebasePerfOkHttpClient.execute(ni.b.f70598a.d().newCall(new Request.Builder().url(str == null ? "" : str).build()));
            if (!execute.isSuccessful()) {
                oi.a.g(oi.a.f71145a, null, f42288a.b() + " --> downloadFile() --> 素材加载失败 --> destination = " + destination + " --> response = " + execute.message() + " --> url = " + str, 6, false, 9, null);
                return false;
            }
            ResponseBody body = execute.body();
            if (body == null || (byteStream = body.byteStream()) == null) {
                h hVar = f42288a;
                oi.a.g(oi.a.f71145a, null, hVar.b() + " --> downloadFile() --> 素材加载失败 --> response.body() == null || response.body?.byteStream()", 0, false, 13, null);
                return false;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(byteStream);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(destination);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                Unit unit = Unit.f67184a;
                                CloseableKt.a(fileOutputStream, null);
                                CloseableKt.a(bufferedInputStream, null);
                                CloseableKt.a(byteStream, null);
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(bufferedInputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(byteStream, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(Result.m1185constructorimpl(ResultKt.a(th6)));
            if (m1188exceptionOrNullimpl == null) {
                throw new KotlinNothingValueException();
            }
            oi.a.g(oi.a.f71145a, null, f42288a.b() + " --> downloadFile() --> 素材加载失败 --> destination = " + destination + " --> it = " + m1188exceptionOrNullimpl + " --> url = " + str, 6, false, 9, null);
            return false;
        }
    }
}

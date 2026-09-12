package com.vungle.ads.internal.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.vungle.ads.R$raw;
import com.vungle.ads.internal.util.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public final class b {
    public static final a Companion = new a(null);
    private static final String OM_SDK_JS = "omsdk.js";
    private static final String OM_SESSION_JS = "omsdk-session.js";
    private AtomicReference<String> cachedOMSDKJS;
    private AtomicReference<String> cachedOMSessionJS;
    private final Context context;
    private final Handler uiHandler;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Context context) {
        Intrinsics.h(context, "context");
        this.context = context;
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.cachedOMSDKJS = new AtomicReference<>(null);
        this.cachedOMSessionJS = new AtomicReference<>(null);
    }

    private final String getOMSessionJS() {
        String str = this.cachedOMSessionJS.get();
        if (str != null) {
            return str;
        }
        String loadJsFromRaw = loadJsFromRaw(R$raw.omid_session_client_v1_5_3);
        this.cachedOMSessionJS.set(loadJsFromRaw);
        return loadJsFromRaw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-2, reason: not valid java name */
    public static final void m1065init$lambda2(b this$0) {
        Object m1185constructorimpl;
        Intrinsics.h(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!re.a.b()) {
                re.a.a(this$0.context);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            o.Companion.e("OMSDK", "error: " + m1188exceptionOrNullimpl.getLocalizedMessage());
        }
    }

    private final String loadJsFromRaw(int i11) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream openRawResource = this.context.getResources().openRawResource(i11);
            Intrinsics.g(openRawResource, "context.resources.openRawResource(resId)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, Charsets.UTF_8), 8192);
            try {
                String e11 = TextStreamsKt.e(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                m1185constructorimpl = Result.m1185constructorimpl(e11);
            } finally {
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        return (String) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    private final File writeToFile(String str, File file) {
        if (str == null) {
            throw new IOException("omsdk js must not be null");
        }
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write(str);
            fileWriter.flush();
            CloseableKt.a(fileWriter, null);
            return file;
        } finally {
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getOMSDKJS$vungle_ads_release() {
        String str = this.cachedOMSDKJS.get();
        if (str != null) {
            return str;
        }
        String loadJsFromRaw = loadJsFromRaw(R$raw.omsdk_v1_5_3);
        this.cachedOMSDKJS.set(loadJsFromRaw);
        return loadJsFromRaw;
    }

    public final void init() {
        this.uiHandler.post(new Runnable() { // from class: com.vungle.ads.internal.omsdk.a
            @Override // java.lang.Runnable
            public final void run() {
                b.m1065init$lambda2(b.this);
            }
        });
    }

    public final List<File> injectJsFiles$vungle_ads_release(File dir) {
        Intrinsics.h(dir, "dir");
        String oMSDKJS$vungle_ads_release = getOMSDKJS$vungle_ads_release();
        File writeToFile = oMSDKJS$vungle_ads_release != null ? writeToFile(oMSDKJS$vungle_ads_release, new File(dir, OM_SDK_JS)) : null;
        String oMSessionJS = getOMSessionJS();
        return CollectionsKt.p(writeToFile, oMSessionJS != null ? writeToFile(oMSessionJS, new File(dir, OM_SESSION_JS)) : null);
    }
}

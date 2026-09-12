package com.transsion.transfer.impl.server.service;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.server.MalformedRangeException;
import com.transsion.transfer.androidasync.http.server.q;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.i;
import iv.c;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;

/* loaded from: classes6.dex */
public final class a implements q {

    /* renamed from: c, reason: collision with root package name */
    public static final C0706a f55916c = new C0706a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f55917d = "Transfer-" + a.class.getName();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.transfer.impl.g f55918a;

    /* renamed from: b, reason: collision with root package name */
    private i f55919b;

    /* renamed from: com.transsion.transfer.impl.server.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0706a {
        private C0706a() {
        }

        public /* synthetic */ C0706a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return a.f55917d;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements bv.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f55921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f55922c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f55923d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f55924e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f55925f;

        b(String str, String str2, Ref.LongRef longRef, long j11, Ref.LongRef longRef2) {
            this.f55921b = str;
            this.f55922c = str2;
            this.f55923d = longRef;
            this.f55924e = j11;
            this.f55925f = longRef2;
        }

        @Override // bv.e
        public void a(long j11, long j12) {
            long currentTimeMillis = System.currentTimeMillis();
            Ref.LongRef longRef = this.f55925f;
            if (currentTimeMillis - longRef.element < 2000) {
                return;
            }
            longRef.element = System.currentTimeMillis();
            i iVar = a.this.f55919b;
            String str = this.f55921b;
            String str2 = this.f55922c;
            long j13 = this.f55923d.element;
            iVar.h(str, str2, j11 + j13, j12 + j13);
        }

        @Override // bv.e
        public void b(Exception exc) {
            a.f55916c.a();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("transfer file onComplete: ");
            sb2.append(message);
            i iVar = a.this.f55919b;
            String str = this.f55921b;
            String str2 = this.f55922c;
            TaskState taskState = exc == null ? TaskState.FINISH : TaskState.ERROR;
            long j11 = this.f55924e;
            iVar.K(str, str2, taskState, j11, j11);
        }
    }

    public a(com.transsion.transfer.impl.g fileHandler, i listener) {
        Intrinsics.h(fileHandler, "fileHandler");
        Intrinsics.h(listener, "listener");
        this.f55918a = fileHandler;
        this.f55919b = listener;
    }

    private final long d(com.transsion.transfer.androidasync.http.server.b bVar) {
        String str;
        List l11;
        List l12;
        Headers headers;
        if (bVar == null || (headers = bVar.getHeaders()) == null || (str = headers.c("Range")) == null) {
            str = "";
        }
        if (str.length() <= 0) {
            return 0L;
        }
        List<String> split = new Regex(UrlUtils.EQUAL_MARK).split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    l11 = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        l11 = CollectionsKt.l();
        String[] strArr = (String[]) l11.toArray(new String[0]);
        if (strArr.length != 2 || !Intrinsics.c("bytes", strArr[0])) {
            return 0L;
        }
        List<String> split2 = new Regex("-").split(strArr[1], 0);
        if (!split2.isEmpty()) {
            ListIterator<String> listIterator2 = split2.listIterator(split2.size());
            while (listIterator2.hasPrevious()) {
                if (listIterator2.previous().length() != 0) {
                    l12 = CollectionsKt.K0(split2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
        }
        l12 = CollectionsKt.l();
        String[] strArr2 = (String[]) l12.toArray(new String[0]);
        try {
            if (strArr2.length > 2) {
                throw new MalformedRangeException();
            }
            if (TextUtils.isEmpty(strArr2[0])) {
                return 0L;
            }
            return Long.parseLong(strArr2[0]);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.q
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        com.transsion.transfer.androidasync.http.server.d c11;
        Multimap h11;
        String string;
        Ref.LongRef longRef = new Ref.LongRef();
        c.a aVar = iv.c.f65742d;
        Triple c12 = aVar.c(bVar != null ? bVar.getHeaders() : null);
        int intValue = ((Number) c12.getSecond()).intValue();
        String str = (String) c12.getThird();
        if (intValue < 1) {
            if (dVar != null) {
                dVar.send(aVar.a(-1, "protocol version compatible error", ""));
                return;
            }
            return;
        }
        String a11 = (bVar == null || (h11 = bVar.h()) == null || (string = h11.getString(OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE)) == null) ? null : jv.a.a(string);
        File file = a11 != null ? new File(a11) : null;
        long d11 = d(bVar);
        long longValue = (file != null ? Long.valueOf(file.length()) : Integer.MAX_VALUE).longValue();
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = d11;
        if (file != null && file.exists()) {
            if (dVar != null) {
                dVar.n(file, new b(str, a11, longRef2, longValue, longRef));
                return;
            }
            return;
        }
        if (a11 != null) {
            this.f55919b.K(str, a11, TaskState.NO_FILE, 0L, longValue);
        }
        String a12 = aVar.a(-1, "File not found," + a11, "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("createResponseJsonObj: ");
        sb2.append(a12);
        if (dVar == null || (c11 = dVar.c(TTAdConstant.DEEPLINK_FALLBACK_CODE)) == null) {
            return;
        }
        c11.send(a12);
    }
}

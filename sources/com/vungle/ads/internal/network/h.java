package com.vungle.ads.internal.network;

import com.vungle.ads.TpatError;
import com.vungle.ads.internal.network.f;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.o;
import com.vungle.ads.internal.util.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlinx.serialization.json.a;

/* loaded from: classes7.dex */
public final class h {
    public static final a Companion = new a(null);
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final String TAG = "TpatSender";
    private final Executor jobExecutor;
    private final SignalManager signalManager;
    private final com.vungle.ads.internal.persistence.b tpatFilePreferences;
    private final Object tpatLock;
    private final VungleApiClient vungleApiClient;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(VungleApiClient vungleApiClient, Executor ioExecutor, Executor jobExecutor, p pathProvider, SignalManager signalManager) {
        Intrinsics.h(vungleApiClient, "vungleApiClient");
        Intrinsics.h(ioExecutor, "ioExecutor");
        Intrinsics.h(jobExecutor, "jobExecutor");
        Intrinsics.h(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient;
        this.jobExecutor = jobExecutor;
        this.signalManager = signalManager;
        this.tpatFilePreferences = com.vungle.ads.internal.persistence.b.Companion.get(ioExecutor, pathProvider, com.vungle.ads.internal.persistence.b.TPAT_FAILED_FILENAME);
        this.tpatLock = new Object();
    }

    public /* synthetic */ h(VungleApiClient vungleApiClient, Executor executor, Executor executor2, p pVar, SignalManager signalManager, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(vungleApiClient, executor, executor2, pVar, (i11 & 16) != 0 ? null : signalManager);
    }

    private final Map<String, c> getStoredTpats() {
        Object m1185constructorimpl;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0844a c0844a = kotlinx.serialization.json.a.f68354d;
                f00.c a11 = c0844a.a();
                KTypeProjection.Companion companion2 = KTypeProjection.INSTANCE;
                kotlinx.serialization.b b11 = kotlinx.serialization.h.b(a11, Reflection.d(Reflection.o(Map.class, companion2.a(Reflection.m(String.class)), companion2.a(Reflection.m(c.class)))));
                Intrinsics.f(b11, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                m1185constructorimpl = Result.m1185constructorimpl((Map) c0844a.b(b11, string));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                o.Companion.e(TAG, "Failed to decode stored tpats: " + m1188exceptionOrNullimpl);
            }
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
                m1185constructorimpl = new LinkedHashMap();
            }
            Map<String, c> map = (Map) m1185constructorimpl;
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final boolean isPriorityTpat(String str) {
        return Intrinsics.c(str, com.vungle.ads.internal.b.CHECKPOINT_0) || Intrinsics.c(str, com.vungle.ads.internal.b.CLICK_URL) || Intrinsics.c(str, "impression") || Intrinsics.c(str, com.vungle.ads.internal.b.LOAD_AD);
    }

    private final void logTpatError(f fVar, String str, com.vungle.ads.internal.model.e eVar, Sdk$SDKError.Reason reason) {
        String str2 = "tpat key: " + fVar.getTpatKey() + ", error: " + eVar.getDescription() + ", errorIsTerminal: " + eVar.getErrorIsTerminal() + " url: " + str;
        o.Companion.e(TAG, str2);
        new TpatError(reason, str2).setLogEntry$vungle_ads_release(fVar.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r2 < r11.getPriorityRetryCount()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_RETRY_FAILED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        logTpatError(r11, r12, r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_ERROR;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.vungle.ads.internal.model.e performPriorityRetry(com.vungle.ads.internal.network.f r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.Boolean r0 = r11.getPriorityRetry()
            if (r0 == 0) goto Lb
            boolean r0 = r0.booleanValue()
            goto L13
        Lb:
            java.lang.String r0 = r11.getTpatKey()
            boolean r0 = r10.isPriorityTpat(r0)
        L13:
            com.vungle.ads.internal.ConfigManager r1 = com.vungle.ads.internal.ConfigManager.INSTANCE
            boolean r1 = r1.retryPriorityTPATs()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L21
            if (r0 == 0) goto L21
            r0 = r3
            goto L22
        L21:
            r0 = r2
        L22:
            com.vungle.ads.internal.network.VungleApiClient r4 = r10.vungleApiClient
            java.util.Map r6 = r11.getHeaders()
            java.lang.String r7 = r11.getBody()
            com.vungle.ads.internal.network.HttpMethod r8 = r11.getMethod()
            com.vungle.ads.internal.util.n r9 = r11.getLogEntry()
            r5 = r12
            com.vungle.ads.internal.model.e r1 = r4.pingTPAT(r5, r6, r7, r8, r9)
            if (r0 == 0) goto L4b
            if (r1 == 0) goto L4b
            boolean r4 = r1.isRetryCode()
            if (r4 != r3) goto L4b
            int r2 = r2 + 1
            int r4 = r11.getPriorityRetryCount()
            if (r2 < r4) goto L22
        L4b:
            if (r1 == 0) goto L5b
            int r0 = r11.getPriorityRetryCount()
            if (r2 < r0) goto L56
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_RETRY_FAILED
            goto L58
        L56:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.TPAT_ERROR
        L58:
            r10.logTpatError(r11, r12, r1, r0)
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.h.performPriorityRetry(com.vungle.ads.internal.network.f, java.lang.String):com.vungle.ads.internal.model.e");
    }

    private final void saveStoredTpats(Map<String, c> map) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.vungle.ads.internal.persistence.b bVar = this.tpatFilePreferences;
            a.C0844a c0844a = kotlinx.serialization.json.a.f68354d;
            f00.c a11 = c0844a.a();
            KTypeProjection.Companion companion2 = KTypeProjection.INSTANCE;
            kotlinx.serialization.b b11 = kotlinx.serialization.h.b(a11, Reflection.d(Reflection.o(Map.class, companion2.a(Reflection.m(String.class)), companion2.a(Reflection.m(c.class)))));
            Intrinsics.f(b11, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            bVar.put(FAILED_TPATS, c0844a.c(b11, map)).apply();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            o.Companion.e(TAG, "Failed to encode the about to storing tpats: " + map);
        }
    }

    public static /* synthetic */ void sendTpat$default(h hVar, f fVar, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        hVar.sendTpat(fVar, z10);
    }

    /* renamed from: sendTpat$lambda-1 */
    public static final void m1064sendTpat$lambda1(h this$0, f request, String urlWithSessionId, boolean z10) {
        c cVar;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(request, "$request");
        Intrinsics.h(urlWithSessionId, "$urlWithSessionId");
        com.vungle.ads.internal.model.e performPriorityRetry = this$0.performPriorityRetry(request, urlWithSessionId);
        if (request.getRegularRetry()) {
            if (performPriorityRetry == null || !performPriorityRetry.getErrorIsTerminal()) {
                if (performPriorityRetry != null || z10) {
                    synchronized (this$0.tpatLock) {
                        try {
                            Map<String, c> storedTpats = this$0.getStoredTpats();
                            c cVar2 = storedTpats.get(request.getUrl());
                            int retryAttempt = cVar2 != null ? cVar2.getRetryAttempt() : 0;
                            if (performPriorityRetry == null && retryAttempt > 0) {
                                storedTpats.remove(request.getUrl());
                                this$0.saveStoredTpats(storedTpats);
                            } else if (performPriorityRetry != null && retryAttempt >= request.getRegularRetryCount()) {
                                storedTpats.remove(request.getUrl());
                                this$0.saveStoredTpats(storedTpats);
                                this$0.logTpatError(request, urlWithSessionId, performPriorityRetry, Sdk$SDKError.Reason.TPAT_RETRY_FAILED);
                            } else if (performPriorityRetry != null) {
                                c cVar3 = storedTpats.get(request.getUrl());
                                if (cVar3 == null || (cVar = c.copy$default(cVar3, null, null, null, retryAttempt + 1, 0, null, 55, null)) == null) {
                                    cVar = new c(request.getMethod(), request.getHeaders(), request.getBody(), 1, request.getRegularRetryCount(), request.getTpatKey());
                                }
                                storedTpats.put(request.getUrl(), cVar);
                                this$0.saveStoredTpats(storedTpats);
                            }
                            Unit unit = Unit.f67184a;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    public final Executor getJobExecutor() {
        return this.jobExecutor;
    }

    public final SignalManager getSignalManager() {
        return this.signalManager;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final String injectSessionIdToUrl(String url) {
        Intrinsics.h(url, "url");
        SignalManager signalManager = this.signalManager;
        String uuid = signalManager != null ? signalManager.getUuid() : null;
        if (uuid == null) {
            uuid = "";
        }
        if (uuid.length() <= 0) {
            return url;
        }
        String quote = Pattern.quote(com.vungle.ads.internal.b.SESSION_ID);
        Intrinsics.g(quote, "quote(Constants.SESSION_ID)");
        return new Regex(quote).replace(url, uuid);
    }

    public final void resendStoredTpats$vungle_ads_release() {
        for (Map.Entry<String, c> entry : getStoredTpats().entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            sendTpat(new f.a(key).regularRetry(true).priorityRetry(false).headers(value.getHeaders()).body(value.getBody()).regularRetryCount(value.getRetryCount()).method(value.getMethod()).tpatKey(value.getTpatKey()).build(), true);
        }
    }

    public final void sendTpat(final f request, final boolean z10) {
        Intrinsics.h(request, "request");
        final String injectSessionIdToUrl = injectSessionIdToUrl(request.getUrl());
        this.jobExecutor.execute(new Runnable() { // from class: com.vungle.ads.internal.network.g
            @Override // java.lang.Runnable
            public final void run() {
                h.m1064sendTpat$lambda1(h.this, request, injectSessionIdToUrl, z10);
            }
        });
    }
}

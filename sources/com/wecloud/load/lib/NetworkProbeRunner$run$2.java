package com.wecloud.load.lib;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.Gson;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.wecloud.load.lib.NetworkProbeRunner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.r0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "", "Lcom/wecloud/load/lib/n;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.wecloud.load.lib.NetworkProbeRunner$run$2", f = "NetworkProbeRunner.kt", l = {TmcConstants.NOTIFY_ADDHOME_GUIDE_BOTTOM_SHOW}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class NetworkProbeRunner$run$2 extends SuspendLambda implements Function2<n0, Continuation<? super List<? extends n>>, Object> {
    final /* synthetic */ String $payloadJson;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/n0;", "", "Lcom/wecloud/load/lib/n;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.wecloud.load.lib.NetworkProbeRunner$run$2$1", f = "NetworkProbeRunner.kt", l = {TsExtractor.TS_STREAM_TYPE_DVBSUBS}, m = "invokeSuspend")
    @SourceDebugExtension
    /* renamed from: com.wecloud.load.lib.NetworkProbeRunner$run$2$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super List<? extends n>>, Object> {
        final /* synthetic */ List<NetworkProbeRunner.Link> $links;
        final /* synthetic */ kotlinx.coroutines.sync.h $semaphore;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<NetworkProbeRunner.Link> list, kotlinx.coroutines.sync.h hVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$links = list;
            this.$semaphore = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$links, this.$semaphore, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super List<n>> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r0 b11;
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                n0 n0Var = (n0) this.L$0;
                List<NetworkProbeRunner.Link> list = this.$links;
                kotlinx.coroutines.sync.h hVar = this.$semaphore;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    b11 = kotlinx.coroutines.k.b(n0Var, null, null, new NetworkProbeRunner$run$2$1$1$1(hVar, (NetworkProbeRunner.Link) it.next(), null), 3, null);
                    arrayList.add(b11);
                }
                this.label = 1;
                obj = kotlinx.coroutines.f.a(arrayList, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkProbeRunner$run$2(String str, Continuation<? super NetworkProbeRunner$run$2> continuation) {
        super(2, continuation);
        this.$payloadJson = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkProbeRunner$run$2 networkProbeRunner$run$2 = new NetworkProbeRunner$run$2(this.$payloadJson, continuation);
        networkProbeRunner$run$2.L$0 = obj;
        return networkProbeRunner$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super List<n>> continuation) {
        return ((NetworkProbeRunner$run$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        Integer maxConcurrency;
        Gson gson;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String str = this.$payloadJson;
            try {
                Result.Companion companion = Result.INSTANCE;
                gson = NetworkProbeRunner.f60936b;
                m1185constructorimpl = Result.m1185constructorimpl((NetworkProbeRunner.Payload) gson.fromJson(str, NetworkProbeRunner.Payload.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            NetworkProbeRunner.Payload payload = (NetworkProbeRunner.Payload) m1185constructorimpl;
            List<NetworkProbeRunner.Link> proberLinks = payload != null ? payload.getProberLinks() : null;
            if (proberLinks == null) {
                proberLinks = CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = proberLinks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String url = ((NetworkProbeRunner.Link) next).getUrl();
                if (!(url == null || StringsKt.q0(url))) {
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                return CollectionsKt.l();
            }
            int f12 = RangesKt.f((payload == null || (maxConcurrency = payload.getMaxConcurrency()) == null) ? 0 : maxConcurrency.intValue(), 0);
            if (f12 <= 0) {
                f12 = RangesKt.f(Runtime.getRuntime().availableProcessors(), 1);
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(arrayList, kotlinx.coroutines.sync.k.b(f12, 0, 2, null), null);
            this.label = 1;
            obj = o0.e(anonymousClass1, this);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}

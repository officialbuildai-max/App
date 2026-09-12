package com.transsion.shorttv.db;

import com.transsion.shorttv.db.ShortTvAdUnlockDao;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.shorttv.db.ShortTvAdUnlockDao$DefaultImpls", f = "ShortTvAdUnlockDao.kt", l = {16, 17, 19}, m = "insertOrUpdate")
/* loaded from: classes6.dex */
public final class ShortTvAdUnlockDao$insertOrUpdate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortTvAdUnlockDao$insertOrUpdate$1(Continuation<? super ShortTvAdUnlockDao$insertOrUpdate$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ShortTvAdUnlockDao.DefaultImpls.a(null, null, this);
    }
}

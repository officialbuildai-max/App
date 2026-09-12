package com.transsion.shorttv.db;

import com.transsion.shorttv.db.ShortTvFavoriteDao;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "com.transsion.shorttv.db.ShortTvFavoriteDao$DefaultImpls", f = "ShortTvFavoriteDao.kt", l = {18, 19, 21}, m = "insertOrUpdate")
/* loaded from: classes6.dex */
public final class ShortTvFavoriteDao$insertOrUpdate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortTvFavoriteDao$insertOrUpdate$1(Continuation<? super ShortTvFavoriteDao$insertOrUpdate$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ShortTvFavoriteDao.DefaultImpls.a(null, null, this);
    }
}

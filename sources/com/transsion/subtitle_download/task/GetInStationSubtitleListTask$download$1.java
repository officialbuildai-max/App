package com.transsion.subtitle_download.task;

import com.transsion.subtitle_download.bean.SubtitleAppType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subtitle_download.task.GetInStationSubtitleListTask$download$1", f = "GetInStationSubtitleListTask.kt", l = {67, 72, 73, 78, 84, 100}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class GetInStationSubtitleListTask$download$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $ep;
    final /* synthetic */ int $episode;
    final /* synthetic */ String $ops;
    final /* synthetic */ int $resStreamType;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
    final /* synthetic */ int $se;
    final /* synthetic */ String $shortTvMiniId;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ String $subjectName;
    final /* synthetic */ String $videoResourceId;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55138a;

        static {
            int[] iArr = new int[SubtitleAppType.values().length];
            try {
                iArr[SubtitleAppType.NOVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubtitleAppType.MB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f55138a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GetInStationSubtitleListTask$download$1(int i11, String str, String str2, String str3, int i12, String str4, int i13, Function1<? super Boolean, Unit> function1, String str5, int i14, String str6, Continuation<? super GetInStationSubtitleListTask$download$1> continuation) {
        super(2, continuation);
        this.$resStreamType = i11;
        this.$subjectId = str;
        this.$videoResourceId = str2;
        this.$shortTvMiniId = str3;
        this.$episode = i12;
        this.$resourceId = str4;
        this.$ep = i13;
        this.$resultCallback = function1;
        this.$subjectName = str5;
        this.$se = i14;
        this.$ops = str6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GetInStationSubtitleListTask$download$1 getInStationSubtitleListTask$download$1 = new GetInStationSubtitleListTask$download$1(this.$resStreamType, this.$subjectId, this.$videoResourceId, this.$shortTvMiniId, this.$episode, this.$resourceId, this.$ep, this.$resultCallback, this.$subjectName, this.$se, this.$ops, continuation);
        getInStationSubtitleListTask$download$1.L$0 = obj;
        return getInStationSubtitleListTask$download$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((GetInStationSubtitleListTask$download$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02c3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle_download.task.GetInStationSubtitleListTask$download$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

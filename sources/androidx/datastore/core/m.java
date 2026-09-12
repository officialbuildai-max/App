package androidx.datastore.core;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class m {

    /* loaded from: classes.dex */
    public static final class a extends m {

        /* renamed from: a, reason: collision with root package name */
        private final Function2 f8678a;

        /* renamed from: b, reason: collision with root package name */
        private final kotlinx.coroutines.w f8679b;

        /* renamed from: c, reason: collision with root package name */
        private final r f8680c;

        /* renamed from: d, reason: collision with root package name */
        private final CoroutineContext f8681d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function2 transform, kotlinx.coroutines.w ack, r rVar, CoroutineContext callerContext) {
            super(null);
            Intrinsics.h(transform, "transform");
            Intrinsics.h(ack, "ack");
            Intrinsics.h(callerContext, "callerContext");
            this.f8678a = transform;
            this.f8679b = ack;
            this.f8680c = rVar;
            this.f8681d = callerContext;
        }

        public final kotlinx.coroutines.w a() {
            return this.f8679b;
        }

        public final CoroutineContext b() {
            return this.f8681d;
        }

        public r c() {
            return this.f8680c;
        }

        public final Function2 d() {
            return this.f8678a;
        }
    }

    private m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

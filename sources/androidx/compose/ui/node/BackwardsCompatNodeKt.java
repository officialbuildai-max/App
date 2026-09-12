package androidx.compose.ui.node;

import androidx.compose.ui.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class BackwardsCompatNodeKt {

    /* renamed from: a */
    private static final a f5296a = new a();

    /* renamed from: b */
    private static final Function1 f5297b = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$onDrawCacheReadsChanged$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BackwardsCompatNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.G1();
        }
    };

    /* renamed from: c */
    private static final Function1 f5298c = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BackwardsCompatNode) obj);
            return Unit.f67184a;
        }

        public final void invoke(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.J1();
        }
    };

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.ui.modifier.k {
        a() {
        }

        @Override // androidx.compose.ui.modifier.k
        public Object P(androidx.compose.ui.modifier.c cVar) {
            return cVar.a().invoke();
        }
    }

    public static final /* synthetic */ a a() {
        return f5296a;
    }

    public static final /* synthetic */ Function1 b() {
        return f5298c;
    }

    public static final /* synthetic */ boolean c(BackwardsCompatNode backwardsCompatNode) {
        return d(backwardsCompatNode);
    }

    public static final boolean d(BackwardsCompatNode backwardsCompatNode) {
        f.c o11 = g.m(backwardsCompatNode).e0().o();
        Intrinsics.f(o11, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((l1) o11).D1();
    }
}

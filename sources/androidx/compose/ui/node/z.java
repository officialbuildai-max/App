package androidx.compose.ui.node;

/* loaded from: classes.dex */
public abstract class z {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(LookaheadCapablePlaceable lookaheadCapablePlaceable, androidx.compose.ui.layout.a aVar) {
        LookaheadCapablePlaceable W0 = lookaheadCapablePlaceable.W0();
        if (!(W0 != null)) {
            g0.a.b("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.b1().v().containsKey(aVar)) {
            Integer num = (Integer) lookaheadCapablePlaceable.b1().v().get(aVar);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int T0 = W0.T0(aVar);
        if (T0 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        W0.o1(true);
        lookaheadCapablePlaceable.n1(true);
        lookaheadCapablePlaceable.m1();
        W0.o1(false);
        lookaheadCapablePlaceable.n1(false);
        return T0 + (aVar instanceof androidx.compose.ui.layout.h ? o0.p.i(W0.e1()) : o0.p.h(W0.e1()));
    }
}

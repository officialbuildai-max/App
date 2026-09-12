package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewNode;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {

    /* renamed from: b, reason: collision with root package name */
    public static final int f2703b = androidx.compose.runtime.collection.b.f3755d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f2704a = new androidx.compose.runtime.collection.b(new ContentInViewNode.a[16], 0);

    public final void b(Throwable th2) {
        androidx.compose.runtime.collection.b bVar = this.f2704a;
        int n11 = bVar.n();
        kotlinx.coroutines.n[] nVarArr = new kotlinx.coroutines.n[n11];
        for (int i11 = 0; i11 < n11; i11++) {
            nVarArr[i11] = ((ContentInViewNode.a) bVar.m()[i11]).a();
        }
        for (int i12 = 0; i12 < n11; i12++) {
            nVarArr[i12].cancel(th2);
        }
        if (!this.f2704a.p()) {
            throw new IllegalStateException("uncancelled requests present");
        }
    }

    public final boolean c(final ContentInViewNode.a aVar) {
        y.i iVar = (y.i) aVar.b().invoke();
        if (iVar == null) {
            kotlinx.coroutines.n a11 = aVar.a();
            Result.Companion companion = Result.INSTANCE;
            a11.resumeWith(Result.m1185constructorimpl(Unit.f67184a));
            return false;
        }
        aVar.a().invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f67184a;
            }

            public final void invoke(Throwable th2) {
                androidx.compose.runtime.collection.b bVar;
                bVar = BringIntoViewRequestPriorityQueue.this.f2704a;
                bVar.t(aVar);
            }
        });
        IntRange intRange = new IntRange(0, this.f2704a.n() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                y.i iVar2 = (y.i) ((ContentInViewNode.a) this.f2704a.m()[last]).b().invoke();
                if (iVar2 != null) {
                    y.i m11 = iVar.m(iVar2);
                    if (Intrinsics.c(m11, iVar)) {
                        this.f2704a.a(last + 1, aVar);
                        return true;
                    }
                    if (!Intrinsics.c(m11, iVar2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int n11 = this.f2704a.n() - 1;
                        if (n11 <= last) {
                            while (true) {
                                ((ContentInViewNode.a) this.f2704a.m()[last]).a().cancel(cancellationException);
                                if (n11 == last) {
                                    break;
                                }
                                n11++;
                            }
                        }
                    }
                }
                if (last == first) {
                    break;
                }
                last--;
            }
        }
        this.f2704a.a(0, aVar);
        return true;
    }

    public final void d() {
        IntRange intRange = new IntRange(0, this.f2704a.n() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                ((ContentInViewNode.a) this.f2704a.m()[first]).a().resumeWith(Result.m1185constructorimpl(Unit.f67184a));
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        this.f2704a.h();
    }
}

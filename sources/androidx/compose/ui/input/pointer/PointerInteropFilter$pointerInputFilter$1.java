package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private PointerInteropFilter.DispatchToViewState f5025b = PointerInteropFilter.DispatchToViewState.Unknown;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ PointerInteropFilter f5026c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.f5026c = pointerInteropFilter;
    }

    private final void h(o oVar) {
        List b11 = oVar.b();
        int size = b11.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((w) b11.get(i11)).p()) {
                if (this.f5025b == PointerInteropFilter.DispatchToViewState.Dispatching) {
                    androidx.compose.ui.layout.l b12 = b();
                    if (b12 == null) {
                        throw new IllegalStateException("layoutCoordinates not set");
                    }
                    long Y = b12.Y(y.g.f78593b.c());
                    final PointerInteropFilter pointerInteropFilter = this.f5026c;
                    f0.b(oVar, Y, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((MotionEvent) obj);
                            return Unit.f67184a;
                        }

                        public final void invoke(MotionEvent motionEvent) {
                            PointerInteropFilter.this.i().invoke(motionEvent);
                        }
                    });
                }
                this.f5025b = PointerInteropFilter.DispatchToViewState.NotDispatching;
                return;
            }
        }
        androidx.compose.ui.layout.l b13 = b();
        if (b13 == null) {
            throw new IllegalStateException("layoutCoordinates not set");
        }
        long Y2 = b13.Y(y.g.f78593b.c());
        final PointerInteropFilter pointerInteropFilter2 = this.f5026c;
        f0.c(oVar, Y2, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MotionEvent) obj);
                return Unit.f67184a;
            }

            public final void invoke(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    pointerInteropFilter2.i().invoke(motionEvent);
                } else {
                    PointerInteropFilter$pointerInputFilter$1.this.f5025b = ((Boolean) pointerInteropFilter2.i().invoke(motionEvent)).booleanValue() ? PointerInteropFilter.DispatchToViewState.Dispatching : PointerInteropFilter.DispatchToViewState.NotDispatching;
                }
            }
        });
        if (this.f5025b == PointerInteropFilter.DispatchToViewState.Dispatching) {
            int size2 = b11.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((w) b11.get(i12)).a();
            }
            g c11 = oVar.c();
            if (c11 == null) {
                return;
            }
            c11.e(!this.f5026c.a());
        }
    }

    private final void i() {
        this.f5025b = PointerInteropFilter.DispatchToViewState.Unknown;
        this.f5026c.j(false);
    }

    @Override // androidx.compose.ui.input.pointer.c0
    public boolean c() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.c0
    public void d() {
        if (this.f5025b == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.f5026c;
            f0.a(uptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MotionEvent) obj);
                    return Unit.f67184a;
                }

                public final void invoke(MotionEvent motionEvent) {
                    PointerInteropFilter.this.i().invoke(motionEvent);
                }
            });
            i();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.input.pointer.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(androidx.compose.ui.input.pointer.o r5, androidx.compose.ui.input.pointer.PointerEventPass r6, long r7) {
        /*
            r4 = this;
            java.util.List r7 = r5.b()
            androidx.compose.ui.input.pointer.PointerInteropFilter r8 = r4.f5026c
            boolean r8 = r8.a()
            r0 = 0
            if (r8 != 0) goto L2c
            int r8 = r7.size()
            r1 = r0
        L12:
            if (r1 >= r8) goto L2a
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.pointer.w r2 = (androidx.compose.ui.input.pointer.w) r2
            boolean r3 = androidx.compose.ui.input.pointer.p.b(r2)
            if (r3 != 0) goto L2c
            boolean r2 = androidx.compose.ui.input.pointer.p.d(r2)
            if (r2 == 0) goto L27
            goto L2c
        L27:
            int r1 = r1 + 1
            goto L12
        L2a:
            r8 = r0
            goto L2d
        L2c:
            r8 = 1
        L2d:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r1 = r4.f5025b
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r2 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r1 == r2) goto L45
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r6 != r1) goto L3c
            if (r8 == 0) goto L3c
            r4.h(r5)
        L3c:
            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r6 != r1) goto L45
            if (r8 != 0) goto L45
            r4.h(r5)
        L45:
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r6 != r5) goto L62
            int r5 = r7.size()
        L4d:
            if (r0 >= r5) goto L5f
            java.lang.Object r6 = r7.get(r0)
            androidx.compose.ui.input.pointer.w r6 = (androidx.compose.ui.input.pointer.w) r6
            boolean r6 = androidx.compose.ui.input.pointer.p.d(r6)
            if (r6 != 0) goto L5c
            goto L62
        L5c:
            int r0 = r0 + 1
            goto L4d
        L5f:
            r4.i()
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.e(androidx.compose.ui.input.pointer.o, androidx.compose.ui.input.pointer.PointerEventPass, long):void");
    }
}

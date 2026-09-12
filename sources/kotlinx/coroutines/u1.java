package kotlinx.coroutines;

/* loaded from: classes7.dex */
public class u1 extends JobSupport implements z {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f68124a;

    public u1(t1 t1Var) {
        super(true);
        initParentJob(t1Var);
        this.f68124a = X();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        r0 = r0.getParentHandle$kotlinx_coroutines_core();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.u) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r0 = (kotlinx.coroutines.u) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r0 = r0.t();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x001d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r0 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.getHandlesException$kotlinx_coroutines_core() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean X() {
        /*
            r4 = this;
            kotlinx.coroutines.t r0 = r4.getParentHandle$kotlinx_coroutines_core()
            boolean r1 = r0 instanceof kotlinx.coroutines.u
            r2 = 0
            if (r1 == 0) goto Lc
            kotlinx.coroutines.u r0 = (kotlinx.coroutines.u) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            r1 = 0
            if (r0 == 0) goto L33
            kotlinx.coroutines.JobSupport r0 = r0.t()
            if (r0 != 0) goto L17
            goto L33
        L17:
            boolean r3 = r0.getHandlesException$kotlinx_coroutines_core()
            if (r3 == 0) goto L1f
            r0 = 1
            return r0
        L1f:
            kotlinx.coroutines.t r0 = r0.getParentHandle$kotlinx_coroutines_core()
            boolean r3 = r0 instanceof kotlinx.coroutines.u
            if (r3 == 0) goto L2a
            kotlinx.coroutines.u r0 = (kotlinx.coroutines.u) r0
            goto L2b
        L2a:
            r0 = r2
        L2b:
            if (r0 == 0) goto L33
            kotlinx.coroutines.JobSupport r0 = r0.t()
            if (r0 != 0) goto L17
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.u1.X():boolean");
    }

    @Override // kotlinx.coroutines.z
    public boolean b(Throwable th2) {
        return makeCompleting$kotlinx_coroutines_core(new b0(th2, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.f68124a;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}

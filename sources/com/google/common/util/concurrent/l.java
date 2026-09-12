package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public abstract class l extends k implements r {

    /* loaded from: classes4.dex */
    public static abstract class a extends l {

        /* renamed from: a, reason: collision with root package name */
        private final r f31088a;

        /* JADX INFO: Access modifiers changed from: protected */
        public a(r rVar) {
            this.f31088a = (r) com.google.common.base.m.o(rVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.k
        /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final r l() {
            return this.f31088a;
        }
    }

    protected l() {
    }

    @Override // com.google.common.util.concurrent.r
    public void addListener(Runnable runnable, Executor executor) {
        delegate().addListener(runnable, executor);
    }

    /* renamed from: m */
    protected abstract r delegate();
}

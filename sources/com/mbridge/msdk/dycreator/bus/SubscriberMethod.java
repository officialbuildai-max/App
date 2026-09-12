package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class SubscriberMethod {

    /* renamed from: a, reason: collision with root package name */
    final Method f34863a;

    /* renamed from: b, reason: collision with root package name */
    final ThreadMode f34864b;

    /* renamed from: c, reason: collision with root package name */
    final Class<?> f34865c;

    /* renamed from: d, reason: collision with root package name */
    String f34866d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f34863a = method;
        this.f34864b = threadMode;
        this.f34865c = cls;
    }

    private synchronized void a() {
        if (this.f34866d == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f34863a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f34863a.getName());
            sb2.append('(');
            sb2.append(this.f34865c.getName());
            this.f34866d = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.f34866d.equals(((SubscriberMethod) obj).f34866d);
    }

    public int hashCode() {
        return this.f34863a.hashCode();
    }
}

package com.apm.insight.runtime;

import androidx.annotation.Nullable;
import com.apm.insight.entity.Header;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static final e f19877b = new e() { // from class: com.apm.insight.runtime.e.1

        /* renamed from: a, reason: collision with root package name */
        private Header f19879a = null;

        @Override // com.apm.insight.runtime.e
        @Nullable
        public final Object b(String str) {
            if (this.f19879a == null) {
                this.f19879a = Header.b(com.apm.insight.e.g());
            }
            return this.f19879a.f().opt(str);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f19878a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this(f19877b);
    }

    private e(e eVar) {
        this.f19878a = eVar;
    }

    @Nullable
    public Object a(String str) {
        e eVar = this.f19878a;
        if (eVar != null) {
            return eVar.a(str);
        }
        return null;
    }

    @Nullable
    public Object b(String str) {
        e eVar = this.f19878a;
        if (eVar != null) {
            return eVar.b(str);
        }
        return null;
    }
}

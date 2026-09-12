package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f22505c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f22506a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22507b;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(List list) {
            e1 e1Var;
            if (list == null) {
                return CollectionsKt.l();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ConfigCodeSeatDTO configCodeSeatDTO = (ConfigCodeSeatDTO) it.next();
                String codeSeatId = configCodeSeatDTO.getCodeSeatId();
                if (codeSeatId != null) {
                    Intrinsics.e(codeSeatId);
                    e1Var = new e1(codeSeatId, GsonUtil.d(configCodeSeatDTO));
                } else {
                    e1Var = null;
                }
                if (e1Var != null) {
                    arrayList.add(e1Var);
                }
            }
            return arrayList;
        }
    }

    public e1(String codeSeatId, String str) {
        Intrinsics.h(codeSeatId, "codeSeatId");
        this.f22506a = codeSeatId;
        this.f22507b = str;
    }

    public final String a() {
        return this.f22506a;
    }

    public final String b() {
        return this.f22507b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1)) {
            return false;
        }
        e1 e1Var = (e1) obj;
        return Intrinsics.c(this.f22506a, e1Var.f22506a) && Intrinsics.c(this.f22507b, e1Var.f22507b);
    }

    public int hashCode() {
        int hashCode = this.f22506a.hashCode() * 31;
        String str = this.f22507b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CloudConfigEntity(codeSeatId=" + this.f22506a + ", code_seat_bean=" + this.f22507b + ')';
    }
}

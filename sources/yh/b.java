package yh;

import com.tn.tranpay.bean.QueryOrderResultContent;
import com.tn.tranpay.bean.QueryStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final QueryOrderResultContent f79140a;

    /* renamed from: b, reason: collision with root package name */
    private final QueryStatus f79141b;

    public b(QueryOrderResultContent queryOrderResultContent, QueryStatus status) {
        Intrinsics.h(status, "status");
        this.f79140a = queryOrderResultContent;
        this.f79141b = status;
    }

    public final QueryOrderResultContent a() {
        return this.f79140a;
    }

    public final QueryStatus b() {
        return this.f79141b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.c(this.f79140a, bVar.f79140a) && this.f79141b == bVar.f79141b;
    }

    public int hashCode() {
        QueryOrderResultContent queryOrderResultContent = this.f79140a;
        return ((queryOrderResultContent == null ? 0 : queryOrderResultContent.hashCode()) * 31) + this.f79141b.hashCode();
    }

    public String toString() {
        return "QueryOrderResult(content=" + this.f79140a + ", status=" + this.f79141b + ")";
    }
}

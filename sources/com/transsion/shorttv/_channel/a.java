package com.transsion.shorttv._channel;

import androidx.view.c0;
import com.transsion.shorttv.bean.Subject;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: com.transsion.shorttv._channel.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0651a implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f52636a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0651a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f52636a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f52636a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52636a.invoke(obj);
        }
    }

    public static final String a(Subject subject, String str) {
        String ops;
        JSONObject jSONObject;
        if (subject != null) {
            try {
                ops = subject.getOps();
            } catch (Exception e11) {
                e11.printStackTrace();
                return subject != null ? subject.getOps() : null;
            }
        } else {
            ops = null;
        }
        if (ops != null && ops.length() != 0) {
            String ops2 = subject.getOps();
            jSONObject = ops2 != null ? new JSONObject(ops2) : new JSONObject();
            jSONObject.put("rec_type", str);
            return jSONObject.toString();
        }
        jSONObject = new JSONObject();
        jSONObject.put("rec_type", str);
        return jSONObject.toString();
    }
}

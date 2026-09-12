package pi;

import android.text.TextUtils;
import com.transsion.ad.monopoly.model.AdPlans;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f72583a = a.f72584a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f72584a = new a();

        private a() {
        }

        public final boolean a(AdPlans adPlans) {
            return TextUtils.equals("AdShowFinal", adPlans != null ? adPlans.getAdShowLevel() : null);
        }
    }
}

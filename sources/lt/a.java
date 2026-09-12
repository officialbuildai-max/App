package lt;

import android.R;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: lt.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0861a {
        public static TextView a(a aVar, View view) {
            Intrinsics.h(view, "view");
            if (view instanceof TextView) {
                if (view.getId() == -1) {
                    view.setId(R.id.message);
                } else if (view.getId() != 16908299) {
                    throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
                }
                return (TextView) view;
            }
            if (!(view.findViewById(R.id.message) instanceof TextView)) {
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            View findViewById = view.findViewById(R.id.message);
            Intrinsics.f(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) findViewById;
        }
    }

    boolean a();

    void cancel();

    int getDuration();

    int getGravity();

    float getHorizontalMargin();

    float getVerticalMargin();

    View getView();

    int getXOffset();

    int getYOffset();

    void setDuration(int i11);

    void setGravity(int i11, int i12, int i13);

    void setMargin(float f11, float f12);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}

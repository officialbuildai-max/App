package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private TextView f2158a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f2159b;

    /* loaded from: classes.dex */
    private static final class a {
        @NonNull
        static TextClassifier a(@NonNull TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TextView textView) {
        this.f2158a = (TextView) androidx.core.util.i.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f2159b;
        return textClassifier == null ? a.a(this.f2158a) : textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f2159b = textClassifier;
    }
}

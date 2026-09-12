package oa;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes5.dex */
public class f extends Property {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f71050a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f71050a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f71050a.set(imageView.getImageMatrix());
        return this.f71050a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}

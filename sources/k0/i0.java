package k0;

import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Pair;

/* loaded from: classes2.dex */
public abstract class i0 {
    public static final float c(CharSequence charSequence, TextPaint textPaint) {
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i11 = 0;
        lineInstance.setText(new b0(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue(10, new Comparator() { // from class: k0.h0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d11;
                d11 = i0.d((Pair) obj, (Pair) obj2);
                return d11;
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i12 = i11;
            i11 = next;
            if (i11 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i12), Integer.valueOf(i11)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i11 - i12) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i12), Integer.valueOf(i11)));
                }
            }
            next = lineInstance.next();
        }
        float f11 = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f11 = Math.max(f11, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (k0.m0.a(r2, l0.e.class) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean e(float r1, java.lang.CharSequence r2, android.text.TextPaint r3) {
        /*
            r0 = 0
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L6
            goto L24
        L6:
            boolean r1 = r2 instanceof android.text.Spanned
            if (r1 == 0) goto L1c
            android.text.Spanned r2 = (android.text.Spanned) r2
            java.lang.Class<l0.f> r1 = l0.f.class
            boolean r1 = k0.m0.a(r2, r1)
            if (r1 != 0) goto L26
            java.lang.Class<l0.e> r1 = l0.e.class
            boolean r1 = k0.m0.a(r2, r1)
            if (r1 != 0) goto L26
        L1c:
            float r1 = r3.getLetterSpacing()
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 != 0) goto L26
        L24:
            r1 = 0
            goto L27
        L26:
            r1 = 1
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.i0.e(float, java.lang.CharSequence, android.text.TextPaint):boolean");
    }
}

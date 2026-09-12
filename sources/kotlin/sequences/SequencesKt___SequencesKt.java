package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public class SequencesKt___SequencesKt extends g {
    public static Sequence A(Sequence sequence, int i11) {
        Intrinsics.h(sequence, "<this>");
        if (i11 >= 0) {
            return i11 == 0 ? SequencesKt__SequencesKt.g() : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).b(i11) : new TakeSequence(sequence, i11);
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static Sequence B(Sequence sequence, Function1 predicate) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(predicate, "predicate");
        return new TakeWhileSequence(sequence, predicate);
    }

    public static final Collection C(Sequence sequence, Collection destination) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(destination, "destination");
        Iterator f67553a = sequence.getF67553a();
        while (f67553a.hasNext()) {
            destination.add(f67553a.next());
        }
        return destination;
    }

    public static List D(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator f67553a = sequence.getF67553a();
        if (!f67553a.hasNext()) {
            return CollectionsKt.l();
        }
        Object next = f67553a.next();
        if (!f67553a.hasNext()) {
            return CollectionsKt.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (f67553a.hasNext()) {
            arrayList.add(f67553a.next());
        }
        return arrayList;
    }

    public static List E(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        return (List) C(sequence, new ArrayList());
    }

    public static Iterable n(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static Sequence o(Sequence sequence, int i11) {
        Intrinsics.h(sequence, "<this>");
        if (i11 >= 0) {
            return i11 == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).a(i11) : new DropSequence(sequence, i11);
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static Sequence p(Sequence sequence, Function1 predicate) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(predicate, "predicate");
        return new FilteringSequence(sequence, true, predicate);
    }

    public static final Sequence q(Sequence sequence, Function1 predicate) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(predicate, "predicate");
        return new FilteringSequence(sequence, false, predicate);
    }

    public static Sequence r(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Sequence q11 = q(sequence, new Function1() { // from class: kotlin.sequences.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean s11;
                s11 = SequencesKt___SequencesKt.s(obj);
                return Boolean.valueOf(s11);
            }
        });
        Intrinsics.f(q11, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return q11;
    }

    public static final boolean s(Object obj) {
        return obj == null;
    }

    public static Object t(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator f67553a = sequence.getF67553a();
        if (f67553a.hasNext()) {
            return f67553a.next();
        }
        return null;
    }

    public static final Appendable u(Sequence sequence, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(buffer, "buffer");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        buffer.append(prefix);
        int i12 = 0;
        for (Object obj : sequence) {
            i12++;
            if (i12 > 1) {
                buffer.append(separator);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            StringsKt.a(buffer, obj, function1);
        }
        if (i11 >= 0 && i12 > i11) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String v(Sequence sequence, CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated, Function1 function1) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        return ((StringBuilder) u(sequence, new StringBuilder(), separator, prefix, postfix, i11, truncated, function1)).toString();
    }

    public static /* synthetic */ String w(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return v(sequence, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    public static Object x(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        Iterator f67553a = sequence.getF67553a();
        if (!f67553a.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = f67553a.next();
        while (f67553a.hasNext()) {
            next = f67553a.next();
        }
        return next;
    }

    public static Sequence y(Sequence sequence, Function1 transform) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(transform, "transform");
        return new TransformingSequence(sequence, transform);
    }

    public static Sequence z(Sequence sequence, Function1 transform) {
        Intrinsics.h(sequence, "<this>");
        Intrinsics.h(transform, "transform");
        return SequencesKt.r(new TransformingSequence(sequence, transform));
    }
}

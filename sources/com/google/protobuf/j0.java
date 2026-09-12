package com.google.protobuf;

import com.google.protobuf.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
abstract class j0 {
    private static final j0 FULL_INSTANCE;
    private static final j0 LITE_INSTANCE;

    /* loaded from: classes4.dex */
    private static final class b extends j0 {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> getList(Object obj, long j11) {
            return (List) s1.getObject(obj, j11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> mutableListAt(Object obj, long j11, int i11) {
            h0 h0Var;
            List<L> list = getList(obj, j11);
            if (list.isEmpty()) {
                List<L> h0Var2 = list instanceof i0 ? new h0(i11) : ((list instanceof c1) && (list instanceof y.j)) ? ((y.j) list).mutableCopyWithCapacity(i11) : new ArrayList<>(i11);
                s1.putObject(obj, j11, h0Var2);
                return h0Var2;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i11);
                arrayList.addAll(list);
                s1.putObject(obj, j11, arrayList);
                h0Var = arrayList;
            } else {
                if (!(list instanceof r1)) {
                    if (!(list instanceof c1) || !(list instanceof y.j)) {
                        return list;
                    }
                    y.j jVar = (y.j) list;
                    if (jVar.isModifiable()) {
                        return list;
                    }
                    y.j mutableCopyWithCapacity = jVar.mutableCopyWithCapacity(list.size() + i11);
                    s1.putObject(obj, j11, mutableCopyWithCapacity);
                    return mutableCopyWithCapacity;
                }
                h0 h0Var3 = new h0(list.size() + i11);
                h0Var3.addAll((r1) list);
                s1.putObject(obj, j11, h0Var3);
                h0Var = h0Var3;
            }
            return h0Var;
        }

        @Override // com.google.protobuf.j0
        void makeImmutableListAt(Object obj, long j11) {
            Object unmodifiableList;
            List list = (List) s1.getObject(obj, j11);
            if (list instanceof i0) {
                unmodifiableList = ((i0) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof c1) && (list instanceof y.j)) {
                    y.j jVar = (y.j) list;
                    if (jVar.isModifiable()) {
                        jVar.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            s1.putObject(obj, j11, unmodifiableList);
        }

        @Override // com.google.protobuf.j0
        <E> void mergeListsAt(Object obj, Object obj2, long j11) {
            List list = getList(obj2, j11);
            List mutableListAt = mutableListAt(obj, j11, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            s1.putObject(obj, j11, list);
        }

        @Override // com.google.protobuf.j0
        <L> List<L> mutableListAt(Object obj, long j11) {
            return mutableListAt(obj, j11, 10);
        }
    }

    /* loaded from: classes4.dex */
    private static final class c extends j0 {
        private c() {
            super();
        }

        static <E> y.j getProtobufList(Object obj, long j11) {
            return (y.j) s1.getObject(obj, j11);
        }

        @Override // com.google.protobuf.j0
        void makeImmutableListAt(Object obj, long j11) {
            getProtobufList(obj, j11).makeImmutable();
        }

        @Override // com.google.protobuf.j0
        <E> void mergeListsAt(Object obj, Object obj2, long j11) {
            y.j protobufList = getProtobufList(obj, j11);
            y.j protobufList2 = getProtobufList(obj2, j11);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            s1.putObject(obj, j11, protobufList2);
        }

        @Override // com.google.protobuf.j0
        <L> List<L> mutableListAt(Object obj, long j11) {
            y.j protobufList = getProtobufList(obj, j11);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            y.j mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            s1.putObject(obj, j11, mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    static {
        FULL_INSTANCE = new b();
        LITE_INSTANCE = new c();
    }

    private j0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0 full() {
        return FULL_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0 lite() {
        return LITE_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutableListAt(Object obj, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> mutableListAt(Object obj, long j11);
}

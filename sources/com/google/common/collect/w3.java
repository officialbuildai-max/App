package com.google.common.collect;

import com.google.common.collect.l3;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class w3 {

    /* loaded from: classes4.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Field f30912a;

        private b(Field field) {
            this.f30912a = field;
            field.setAccessible(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Object obj, int i11) {
            try {
                this.f30912a.set(obj, Integer.valueOf(i11));
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(Object obj, Object obj2) {
            try {
                this.f30912a.set(obj, obj2);
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Class cls, String str) {
        try {
            return new b(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e11) {
            throw new AssertionError(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Map map, ObjectInputStream objectInputStream) {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Map map, ObjectInputStream objectInputStream, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(j3 j3Var, ObjectInputStream objectInputStream) {
        e(j3Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(j3 j3Var, ObjectInputStream objectInputStream, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            Collection collection = j3Var.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i13 = 0; i13 < readInt; i13++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(l3 l3Var, ObjectInputStream objectInputStream) {
        g(l3Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(l3 l3Var, ObjectInputStream objectInputStream, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            l3Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Map map, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(j3 j3Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(j3Var.asMap().size());
        for (Map.Entry entry : j3Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(l3 l3Var, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(l3Var.entrySet().size());
        for (l3.a aVar : l3Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}

package io.reactivex.rxjava3.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes7.dex */
public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* loaded from: classes7.dex */
    static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        ExceptionOverview(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class a {
        a() {
        }

        abstract a a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private final PrintStream f65441a;

        b(PrintStream printStream) {
            this.f65441a = printStream;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Object obj) {
            this.f65441a.print(obj);
            return this;
        }
    }

    /* loaded from: classes7.dex */
    static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f65442a;

        c(PrintWriter printWriter) {
            this.f65442a = printWriter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // io.reactivex.rxjava3.exceptions.CompositeException.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Object obj) {
            this.f65442a.print(obj);
            return this;
        }
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th2 : iterable) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void appendStackTrace(a aVar, Throwable th2, String str) {
        aVar.a(str).a(th2).a('\n');
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            aVar.a("\t\tat ").a(stackTraceElement).a('\n');
        }
        if (th2.getCause() != null) {
            aVar.a("\tCaused by: ");
            appendStackTrace(aVar, th2.getCause(), "");
        }
    }

    private void printStackTrace(a aVar) {
        aVar.a(this).a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            aVar.a("\tat ").a(stackTraceElement).a("\n");
        }
        int i11 = 1;
        for (Throwable th2 : this.exceptions) {
            aVar.a("  ComposedException ").a(Integer.valueOf(i11)).a(" :\n");
            appendStackTrace(aVar, th2, "\t");
            i11++;
        }
        aVar.a("\n");
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i11;
        try {
            if (this.cause == null) {
                String property = System.getProperty("line.separator");
                if (this.exceptions.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Multiple exceptions (");
                    sb2.append(this.exceptions.size());
                    sb2.append(")");
                    sb2.append(property);
                    for (Throwable th2 : this.exceptions) {
                        int i12 = 0;
                        while (true) {
                            if (th2 != null) {
                                for (int i13 = 0; i13 < i12; i13++) {
                                    sb2.append("  ");
                                }
                                sb2.append("|-- ");
                                sb2.append(th2.getClass().getCanonicalName());
                                sb2.append(": ");
                                String message = th2.getMessage();
                                if (message == null || !message.contains(property)) {
                                    sb2.append(message);
                                    sb2.append(property);
                                } else {
                                    sb2.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i14 = 0; i14 < i12 + 2; i14++) {
                                            sb2.append("  ");
                                        }
                                        sb2.append(str);
                                        sb2.append(property);
                                    }
                                }
                                int i15 = 0;
                                while (true) {
                                    i11 = i12 + 2;
                                    if (i15 >= i11) {
                                        break;
                                    }
                                    sb2.append("  ");
                                    i15++;
                                }
                                StackTraceElement[] stackTrace = th2.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb2.append("at ");
                                    sb2.append(stackTrace[0]);
                                    sb2.append(property);
                                }
                                if (identityHashMap.containsKey(th2)) {
                                    Throwable cause = th2.getCause();
                                    if (cause != null) {
                                        for (int i16 = 0; i16 < i11; i16++) {
                                            sb2.append("  ");
                                        }
                                        sb2.append("|-- ");
                                        sb2.append("(cause not expanded again) ");
                                        sb2.append(cause.getClass().getCanonicalName());
                                        sb2.append(": ");
                                        sb2.append(cause.getMessage());
                                        sb2.append(property);
                                    }
                                } else {
                                    identityHashMap.put(th2, Boolean.TRUE);
                                    th2 = th2.getCause();
                                    i12++;
                                }
                            }
                        }
                    }
                    this.cause = new ExceptionOverview(sb2.toString().trim());
                } else {
                    this.cause = this.exceptions.get(0);
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return this.cause;
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new b(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new c(printWriter));
    }

    public int size() {
        return this.exceptions.size();
    }
}

package org.fscl.core.domain.entity.id;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class FsclEntityCode {
    public final String prefix;
    public final String postfix;
    public final String segmentSeparator;

    
    @EqualsAndHashCode.Include
    protected List<String> segments;

    public FsclEntityCode(String prefix, String postfix, List<String> segments, String segmentSeparator)  {
        this.prefix = prefix;
        this.postfix = postfix;
        this.segmentSeparator = segmentSeparator;
        this.segments =  new ArrayList<String>(segments);
    }

    public static abstract class Builder<T extends FsclEntityCode> {
        protected boolean isShadow = false;
        protected final List<String> segms;

        protected final String segmentSeparator;
        protected static final String REGEXP = "\\d{1,4}|[A-Z]{1,4}|[a-z]{1,4}";


        public Builder(String segmentSeparator) {
            segms = new ArrayList<>();
            this.segmentSeparator = segmentSeparator;

        }

        public Builder<T> withSegment(String segment) throws SegmentMismatchException {
            Pattern pattern = Pattern.compile(REGEXP);
            if (pattern.matcher(segment).matches() ) {
                this.segms.add(segment);
                return this;
            }

            throw new SegmentMismatchException(segment);
        }

        public Builder<T> withPrefix(String prefix) throws PrefixMismatchException {
            if( ! prefix.equals(this.prefix())) {
                throw new PrefixMismatchException(this.prefix(), prefix);
            }

            return this;
        }

        public Builder<T> withPostfix(String postfix) throws PostfixMismatchException {
            if( ! postfix.equals(this.postfix())) {
                throw new PostfixMismatchException(this.postfix(), postfix);
            }

            return this;
        }

        public Builder<T> withSeparator(String separator) throws SeparatorMismatchException {
            if( ! separator.equals(this.postfix())) {
                throw new SeparatorMismatchException(this.segmentSeparator, separator);
            }

            return this;
        }

        public Builder<T> asShadow() {
            this.isShadow = true;
            return this;
        }
        public abstract T build();
        public abstract Builder<T> withCode(String code) throws
                PrefixMismatchException,
                PostfixMismatchException;

        protected abstract String prefix();
        protected abstract String postfix();
    }

    public String toString() {
        StringBuilder b = new StringBuilder(prefix);

        Iterator<String> iter = segments.iterator();

        if (iter.hasNext() ) {
            b.append(iter.next());
        }

        while (iter.hasNext()) {
            b.append(this.segmentSeparator);
            b.append(iter.next());
        }

        if(this.postfix != null) {
            b.append(this.postfix);
        }

        return b.toString();
    }
}
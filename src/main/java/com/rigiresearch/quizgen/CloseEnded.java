/**
 * Copyright 2017 University of Victoria
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.rigiresearch.quizgen;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * A multiple choice question.
 * @author Miguel Jimenez (miguel@uvic.ca)
 * @date 2017-08-13
 * @version $Id$
 * @since 0.0.1
 */
@Accessors(fluent = true)
@AllArgsConstructor
@Getter
public final class CloseEnded implements Question {

    /**
     * A question's possible answer.
     * @author Miguel Jimenez (miguel@uvic.ca)
     * @date 2017-08-13
     * @version $Id$
     * @since 0.0.1
     */
    @Accessors(fluent = true)
    @AllArgsConstructor
    @Getter
    public static final class Option {

        /**
         * Whether this option represents an answer.
         */
        private final boolean answer;

        /**
         * This option's statement.
         */
        private final TextSegment statement;

    }

    /**
     * This question's statement.
     */
    private final TextSegment statement;

    /**
     * List of possible answers.
     */
    private final List<Option> options;

    /* (non-Javadoc)
     * @see com.rigiresearch.quizgen.Question#statement()
     */
    @Override
    public TextSegment header() {
        return this.statement;
    }

    /* (non-Javadoc)
     * @see com.rigiresearch.quizgen.Question#body()
     */
    @Override
    public List<TextSegment> body() {
        return this.options.stream()
            .map(option -> option.statement())
            .collect(Collectors.toList());
    }

}

/* 
 * Copyright 2014 Frank Asseg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package net.objecthunter.exp4j.function;

public abstract class Function {

    protected final String name;

    protected final int numArguments;

    public Function(String name, int numArguments) {
        this.name = name;
        if (numArguments < 1) {
            throw new IllegalArgumentException("The number of function arguments can not be less than 1 for '" +
                    name + "'");
        }
        this.numArguments = numArguments;

    }

    public Function(String name) {
        if (name == null || name.trim().isEmpty())  {
            throw new IllegalArgumentException("Function name can not be empty");
        }
        if (!Character.isAlphabetic(name.charAt(0)) && name.charAt(0) != '_') {
            throw new IllegalArgumentException("Function name is invalid. Name has to start with a letter or an underscore");
        }
        this.name = name;
        this.numArguments = 1;
    }

    public String getName() {
        return name;
    }

    public int getNumArguments() {
        return numArguments;
    }

    public abstract double apply(double... args);

    public static char[] getAllowedFunctionCharacters() {
        char[] chars = new char[53];
        int count = 0;
        for (int i = 65; i < 91; i++) {
            chars[count++] = (char) i;
        }
        for (int i = 97; i < 123; i++) {
            chars[count++] = (char) i;
        }
        chars[count] = '_';
        return chars;
    }
}

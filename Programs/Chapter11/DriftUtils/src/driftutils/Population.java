/*
 * Copyright 2013 Peter Garst.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package driftutils;

import java.util.Random;

/**
 *
 * @author Peter
 */
public class Population
    {  
    private int size;
    private Random rand;
    private Generation current;

    public Population(int size, Random rand)
        {

        this.rand = rand;
        this.size = size;

        current = new Generation(rand, size);
        }

    public double totalA()
        {

        return current.totalA();
        }

    public void advance()
        {

        Generation newgen   = new Generation(rand, size);

        newgen.breed(current);
        newgen.survive();

        current = newgen;
        }

    }

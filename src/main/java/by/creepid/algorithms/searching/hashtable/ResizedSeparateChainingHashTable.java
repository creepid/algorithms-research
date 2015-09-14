/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.searching.hashtable;

import by.creepid.algorithms.searching.symboltable.LinkedListSymbolTable;
import by.creepid.algorithms.searching.symboltable.SymbolTable;
import by.creepid.algorithms.utils.MathHelper;
import java.util.Iterator;

/**
 *
 * @author mirash
 */
public class ResizedSeparateChainingHashTable<Key, Value> extends SeparateChainingHashTable<Key, Value> {

    private static final int[] dk = {1, 3, 1, 5, 3, 3, 9, 3, 1, 3, 19, 15, 1, 5, 1, 3, 9, 3, 15, 3, 39, 5, 39, 57, 35, 1};
    private static final int START_SIZE = 32;
    private final int averageProbes;

    public ResizedSeparateChainingHashTable(int averageProbes) {
        super(START_SIZE);
        this.averageProbes = averageProbes;
    }

    @Override
    protected int hash(Key key) {
        //mask sign bit (converts 32-bit number to positive 31-bit number)
        int temp = (key.hashCode() & 0x7fffffff);

        int lgM = (int) MathHelper.log2(m);
        if ((lgM - 5) <= dk.length && (lgM - 5) >= 0) {
            int prime = m - dk[lgM - 5];
            temp = temp % prime;
        }

        return temp % m;
    }

    @Override
    public void put(Key key, Value value) {
        SymbolTable<Key, Value> st = chains[hash(key)];

        int originSize = st.size();
        st.put(key, value);
        int afterSize = st.size();

        if (afterSize > originSize) {
            n++;

            if (n / m >= averageProbes) {
                resize(m / 2);
            }
        }
    }


    void resize(int newCapacity) {
        LinkedListSymbolTable<Key, Value>[] oldChains = (LinkedListSymbolTable<Key, Value>[]) this.chains;
        int oldM = this.m;
        
        LinkedListSymbolTable<Key, Value>[] newChains = (LinkedListSymbolTable<Key, Value>[]) new LinkedListSymbolTable[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newChains[i] = new LinkedListSymbolTable();
        }

        this.chains = newChains;
        this.m = newCapacity;

        for (int i = 0; i < oldM; i++) {
            LinkedListSymbolTable<Key, Value> currST = oldChains[i];
            Iterator<Key> iterator = currST.keys().iterator();
            while (iterator.hasNext()) {
                Key currKey = iterator.next();
                this.put(currKey, currST.get(currKey));
            }
        }

    }
}

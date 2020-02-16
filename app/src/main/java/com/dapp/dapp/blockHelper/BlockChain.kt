package com.dapp.dapp.blockHelper

import android.widget.Toast
import com.dapp.dapp.MainApplication
import com.dapp.dapp.helper.PrefManager

class BlockChain {
    var blockChain = PrefManager.loadData()
    fun addBlock(block: Block) {
        checkConflict(block, blockChain)
    }

    fun checkConflict(block: Block, chain: ArrayList<Block>) {
        if (chain.size == 0) {
            blockChain.add(block)
        } else {
            if (chain.last().currentHash != block.previousHash) {
                Toast.makeText(
                    MainApplication.instance,
                    "Current hash didn't matched previous hash",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                blockChain.add(block)
                PrefManager.saveData(blockChain)
            }
        }
    }
}
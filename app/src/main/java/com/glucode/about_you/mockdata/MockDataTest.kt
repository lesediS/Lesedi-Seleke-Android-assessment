package com.glucode.about_you.mockdata

import org.junit.Test

class MockDataTest {

    @Test
    fun testSortEngineersByYears() {
        val sortedEngineers = MockData.sortEngineersBy("years")
    }

    @Test
    fun testSortEngineersByCoffees() {
        val sortedEngineers = MockData.sortEngineersBy("coffees")
    }

    @Test
    fun testSortEngineersByBugs() {
        val sortedEngineers = MockData.sortEngineersBy("bugs")
    }
}

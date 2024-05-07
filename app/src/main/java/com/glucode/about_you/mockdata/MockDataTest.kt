package com.glucode.about_you.mockdata

import org.junit.Test

class MockDataTest {

    @Test
    fun testSortEngineersByYears() {
        val sortedEngineers = MockData.sortEngineersBy("years")
        //TODO: Add assertions to verify the sorting order
    }

    @Test
    fun testSortEngineersByCoffees() {
        val sortedEngineers = MockData.sortEngineersBy("coffees")
        //TODO: Add assertions to verify the sorting order
    }

    @Test
    fun testSortEngineersByBugs() {
        val sortedEngineers = MockData.sortEngineersBy("bugs")
        //TODO: Add assertions to verify the sorting order
    }
}

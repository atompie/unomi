/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oasis_open.contextserver.impl.mergers;

import org.oasis_open.contextserver.api.Profile;
import org.oasis_open.contextserver.api.PropertyMergeStrategyExecutor;
import org.oasis_open.contextserver.api.PropertyType;

import java.util.List;

public class DefaultPropertyMergeStrategyExecutor implements PropertyMergeStrategyExecutor {
    public boolean mergeProperty(String propertyName, PropertyType propertyType, List<Profile> profilesToMerge, Profile targetProfile) {
        boolean modified = false;
        for (Profile profileToMerge : profilesToMerge) {
            if (profileToMerge.getProperty(propertyName) != null &&
                    profileToMerge.getProperty(propertyName).toString().length() > 0) {
                targetProfile.setProperty(propertyName, profileToMerge.getProperty(propertyName));
                modified = true;
            }
        }
        return modified;
    }
}

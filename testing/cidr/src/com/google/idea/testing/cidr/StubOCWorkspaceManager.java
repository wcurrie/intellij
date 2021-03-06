/*
 * Copyright 2017 The Bazel Authors. All rights reserved.
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
package com.google.idea.testing.cidr;

import com.google.idea.sdkcompat.cidr.OCWorkspaceManagerAdapter;
import com.intellij.openapi.project.Project;
import com.jetbrains.cidr.lang.workspace.OCWorkspace;

/**
 * A stub {@link OCWorkspaceManagerAdapter} to use for testing. Also allows toggling on C++ support
 * (which may have been disabled by other OCWorkspaceManagers.
 *
 * <p>Once the plugin API ships with a more official OCWorkspaceManager-for-testing, we may be able
 * to switch over to those classes. See: b/32420569
 */
public class StubOCWorkspaceManager extends OCWorkspaceManagerAdapter {

  private final OCWorkspace workspace;

  public StubOCWorkspaceManager(Project project) {
    this.workspace = new StubOCWorkspace(project);
  }

  @Override
  public OCWorkspace getWorkspace() {
    return workspace;
  }
}
